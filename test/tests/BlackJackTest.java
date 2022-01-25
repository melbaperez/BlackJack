package tests;

import blackjack.BlackJack;
import blackjack.elements.Deck;
import blackjack.elements.Player;
import blackjack.cards.PipCard;
import blackjack.cards.CardWithValueTen;
import blackjack.cards.Card;
import blackjack.cards.Ace;
import blackjack.elements.Hand;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class BlackJackTest {

    @Test
    public void TestGetWinners_Case1() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        
        Hand hand1 = new Hand();
        Player player1 = new Player("player1", hand1);
        hand1.addCard(new CardWithValueTen("J"));
        hand1.addCard(new Ace());
        
        List<Card> cards2 = Arrays.asList(new PipCard(10), new PipCard(5), 
                new PipCard(6));
        Hand hand2 = new Hand(cards2);
        Player player2 = new Player("player2", hand2);
              
        List<Card> cards3 = Arrays.asList(new PipCard(3), new PipCard(6), new Ace(),
                new PipCard(3),new Ace(), new CardWithValueTen("K"));
        Hand hand3 = new Hand(cards3);
        Player player3 = new Player("player3", hand3);
        
        Hand handC = new Hand();
        Player crupier = new Player("crupier", handC);
        handC.addCard(new PipCard(9));
        handC.addCard(new PipCard(7));
        
        Deck deck = new Deck(new LinkedList<>(Arrays.asList(new PipCard(5), 
                new PipCard(4), new CardWithValueTen("K"), new PipCard(2))));

        List<Player> listTestPlayer = Arrays.asList(player1);
       
        BlackJack blackJack = new BlackJack(); 
                
        List<Player> listWinners = blackJack.getWinners(player1,player2,player3,crupier,deck);
        assert(listWinners.equals(listTestPlayer));

    }
    
    @Test
    public void TestGetWinners_Case2() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        
        Hand hand1 = new Hand();
        Player player1 = new Player("player1", hand1);
        hand1.addCard(new PipCard(10));
        hand1.addCard(new CardWithValueTen("K"));
       
        List<Card> cards2 = Arrays.asList(new PipCard(10), new PipCard(2), 
                new PipCard(6));
        Hand hand2 = new Hand(cards2);
        Player player2 = new Player("player2", hand2);
               
        List<Card> cards3 = Arrays.asList(new PipCard(8), new PipCard(8), 
                new PipCard(5));
        Hand hand3 = new Hand(cards3);
        Player player3 = new Player("player3", hand3);
        
        Hand handC = new Hand();
        Player crupier = new Player("crupier", handC);
        handC.addCard(new PipCard(5));
        handC.addCard(new PipCard(10));
        
        Deck deck = new Deck(new LinkedList<>(Arrays.asList(new Ace(), 
                new PipCard(3), new CardWithValueTen("K"), new PipCard(2))));

        List<Player> listTestPlayer = Arrays.asList(player1, player3);
       
        BlackJack blackJack = new BlackJack(); 
                
        List<Player> listWinners = blackJack.getWinners(player1,player2,player3,crupier,deck);
        assert(listWinners.equals(listTestPlayer));

    }
    
    @Test
    public void TestGetWinners_CrupierHasBlackJack() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        
        Hand hand1 = new Hand();
        Player player1 = new Player("player1", hand1);
        hand1.addCard(new Ace());
        hand1.addCard(new CardWithValueTen("K"));
       
        List<Card> cards2 = Arrays.asList(new PipCard(10), new Ace());
        Hand hand2 = new Hand(cards2);
        Player player2 = new Player("player2", hand2);
               
        List<Card> cards3 = Arrays.asList(new PipCard(8), new PipCard(8), 
                new PipCard(5));
        Hand hand3 = new Hand(cards3);
        Player player3 = new Player("player3", hand3);
        
        Hand handC = new Hand();
        Player crupier = new Player("crupier", handC);
        handC.addCard(new Ace());
        handC.addCard(new CardWithValueTen("K"));
        
        Deck deck = new Deck(new LinkedList<>(Arrays.asList(new Ace(), 
                new PipCard(3), new CardWithValueTen("K"), new PipCard(2))));

        List<Player> listTestPlayer = Arrays.asList();
       
        BlackJack blackJack = new BlackJack(); 
                
        List<Player> listWinners = blackJack.getWinners(player1,player2,player3,crupier,deck);
        assert(listWinners.equals(listTestPlayer));

    }
    
    @Test
    public void TestGetWinners_CrupierWins_BiggerHandUnder21() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        
        Hand hand1 = new Hand();
        Player player1 = new Player("player1", hand1);
        hand1.addCard(new PipCard(2));
        hand1.addCard(new CardWithValueTen("K"));
       
        List<Card> cards2 = Arrays.asList(new PipCard(10),new PipCard(5),
                new CardWithValueTen("Q"));
        Hand hand2 = new Hand(cards2);
        Player player2 = new Player("player2", hand2);
               
        List<Card> cards3 = Arrays.asList(new PipCard(8), new PipCard(10));
        Hand hand3 = new Hand(cards3);
        Player player3 = new Player("player3", hand3);
        
        Hand handC = new Hand();
        Player crupier = new Player("crupier", handC);
        handC.addCard(new PipCard(6));
        handC.addCard(new CardWithValueTen("K"));
        
        Deck deck = new Deck(new LinkedList<>(Arrays.asList(new PipCard(2), 
                new CardWithValueTen("K"), new PipCard(2))));

        List<Player> listTestPlayer = Arrays.asList();
       
        BlackJack blackJack = new BlackJack(); 
                
        List<Player> listWinners = blackJack.getWinners(player1,player2,player3,crupier,deck);
        assert(listWinners.equals(listTestPlayer));

    }
    
    @Test
    public void TestGetWinners_PlayersWinCrupier() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        
        Hand hand1 = new Hand();
        Player player1 = new Player("player1", hand1);
        hand1.addCard(new PipCard(8));
        hand1.addCard(new CardWithValueTen("K"));
       
        List<Card> cards2 = Arrays.asList(new PipCard(10),new Ace());
        Hand hand2 = new Hand(cards2);
        Player player2 = new Player("player2", hand2);
               
        List<Card> cards3 = Arrays.asList(new PipCard(8), new PipCard(10));
        Hand hand3 = new Hand(cards3);
        Player player3 = new Player("player3", hand3);
        
        Hand handC = new Hand();
        Player crupier = new Player("crupier", handC);
        handC.addCard(new PipCard(7));
        handC.addCard(new CardWithValueTen("K"));
        
        Deck deck = new Deck(new LinkedList<>(Arrays.asList(new PipCard(3), 
                new CardWithValueTen("K"), new PipCard(2))));

        List<Player> listTestPlayer = Arrays.asList(player1, player2, player3);
       
        BlackJack blackJack = new BlackJack(); 
                
        List<Player> listWinners = blackJack.getWinners(player1,player2,player3,crupier,deck);
        assert(listWinners.equals(listTestPlayer));

    }
    
    
    @Test
    public void TestFillCrupierHand_SumHandBigger17() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        
        Deck deck = new Deck(new LinkedList<>(Arrays.asList(new Ace(), 
                new PipCard(3), new CardWithValueTen("K"), new PipCard(2))));
        
        Hand handC = new Hand();
        Player crupier = new Player("crupier", handC);
        handC.addCard(new PipCard(8));
        handC.addCard(new PipCard(10));
        BlackJack.fillCrupierHand(crupier, deck);
        
        assertEquals(2, handC.getSize());
        assertEquals(18, handC.getSumHand());
        assertEquals(4, deck.getSize());
    }
    
    @Test
    public void TestFillCrupierHand_SumHandLess17_TakeOneCard_Achieves21() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        
        Deck deck = new Deck(new LinkedList<>(Arrays.asList(new Ace(), 
                new PipCard(3), new CardWithValueTen("K"), new PipCard(2))));
        
        Hand handC = new Hand();
        Player crupier = new Player("crupier", handC);
        handC.addCard(new PipCard(8));
        handC.addCard(new PipCard(2));
        BlackJack.fillCrupierHand(crupier, deck);
        
        assertEquals(3, handC.getSize());
        assertEquals(21, handC.getSumHand());
        assertEquals(3, deck.getSize());
    }
    
    @Test
    public void TestFillCrupierHand_SumHandLess17_TakeSomeCards_AchievesMax() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        
        Deck deck = new Deck(new LinkedList<>(Arrays.asList(new PipCard(3),
                new CardWithValueTen("K"), new PipCard(2))));
        
        Hand handC = new Hand();
        Player crupier = new Player("crupier", handC);
        handC.addCard(new PipCard(5));
        handC.addCard(new PipCard(2));
        BlackJack.fillCrupierHand(crupier, deck);
        
        assertEquals(4, handC.getSize());
        assertEquals(20, handC.getSumHand());
        assertEquals(1, deck.getSize());
    }
    
    
    @Test
    public void TestFillCrupierHand_SumHandLess17_SpendAllTheCards_NoAchievesMax() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        
        Deck deck = new Deck(new LinkedList<>(Arrays.asList(new PipCard(3), 
                new PipCard(5), new Ace(), new Ace())));
        
        Hand handC = new Hand();
        Player crupier = new Player("crupier", handC);
        handC.addCard(new PipCard(4));
        handC.addCard(new PipCard(2));
        BlackJack.fillCrupierHand(crupier, deck);
        
        assertEquals(6, handC.getSize());
        assertEquals(16, handC.getSumHand());
        assertEquals(0, deck.getSize());
    }
    
    @Test
    public void TestFillCrupierHand_SumHandIs17() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        
        Deck deck = new Deck(new LinkedList<>(Arrays.asList(new Ace(), 
                new PipCard(1))));
        
        Hand handC = new Hand();
        Player crupier = new Player("crupier", handC);
        handC.addCard(new PipCard(5));
        handC.addCard(new PipCard(1));
        handC.addCard(new Ace());
        BlackJack.fillCrupierHand(crupier, deck);
        
        assertEquals(3, handC.getSize());
        assertEquals(17, handC.getSumHand());
        assertEquals(2, deck.getSize());
    }

}
