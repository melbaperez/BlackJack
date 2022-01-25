package blackjack.elements;

import blackjack.cards.Card;
import java.util.LinkedList;

public class Deck {
    
    private final LinkedList<Card> deck;

    public Deck(LinkedList<Card> deck) {
        this.deck = deck;
    }
    
    public Card getCard(){
        Card card= deck.removeFirst();
        return card;
    }

    public LinkedList<Card> getDeck() {
        return deck;
    }
    
    public int getSize() {
        return deck.size();
    }
    
    @Override
    public String toString(){
        String cards = "";
        for (Card card: deck){
            cards+= card + " ";
        }
        return cards;
    }

}
