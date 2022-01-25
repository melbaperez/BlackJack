package blackjack;

import blackjack.elements.Player;
import blackjack.elements.Hand;
import blackjack.elements.Deck;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackJack {
    private static final int maxCrupier = 17;

    public List<Player> getWinners(Player player1, Player player2, Player player3, 
            Player crupier, Deck deck){
        List<Player> winners = new ArrayList<>();
        List<Player> players = Arrays.asList(player1, player2, player3);
        
        fillCrupierHand(crupier, deck);
        
        if (!crupier.hasBlackJack()){
            for (Player player : players){
                if (player.isWinner(crupier)){
                    winners.add(player);
                }
            }   
        }
        return winners;
    }

    public static void fillCrupierHand(Player crupier, Deck deck) {
        Hand hand = crupier.getHand();
        int sumHand = hand.getSumHand();
        while(sumHand < maxCrupier && deck.getSize()>0){
            hand.addCard(deck.getCard());
            hand = crupier.getHand();
            sumHand = hand.getSumHand();
        }
    }
    
}
