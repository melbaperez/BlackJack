package blackjack.elements;

import blackjack.cards.Ace;
import blackjack.cards.Card;
import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> hand = new ArrayList<>();
    private int sumHand = 0;
    private int numberAces = 0;
    
    public Hand(){}
    
    public Hand(List<Card> cards) {
        cards.forEach((card) -> {
            addCard(card);
        });
    }
    
    public void addCard(Card card){
        hand.add(card);
        sumHand+=card.value();
        isCardAce(card);   
    }
    
    private void isCardAce(Card card){
        if(card instanceof Ace){
                numberAces++;
        }
    }
    
    public int getSumHand() {
        Ace ace = new Ace();
        while(sumHand>21 && numberAces>0){ 
            sumHand-=ace.value()-ace.secondValue(); 
            numberAces--;
        }
        return sumHand;
    }
    
    public int getSize(){
        return hand.size();
    }
    
    public List<Card> getCardsOfHand() {
        return hand;
    }
    
    @Override
    public String toString(){
        String cards = "";
        for (Card card: getCardsOfHand()){
            cards+= card.toString() + " ";
        }
        return cards;
    }

}
