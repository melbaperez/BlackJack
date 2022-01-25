package tests;

import blackjack.cards.Ace;
import blackjack.cards.Card;
import blackjack.cards.CardWithValueTen;
import blackjack.cards.PipCard;
import blackjack.elements.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ElementsTest {
    
    @Test 
    public void PlayerTestName(){
        Hand hand = new Hand();
        Player player1 = new Player("player1", hand);
        assertEquals("player1", player1.getNamePlayer());
    }
    
    @Test 
    public void PlayerTestHand() throws PipCard.IncorrectValueException {
        List<Card> cards = Arrays.asList(new PipCard(8), new PipCard(8), 
                new PipCard(5));
        Hand hand = new Hand(cards);
        Player player = new Player("player1", hand);
        assertEquals(hand, player.getHand());
    }
    
    @Test 
    public void PlayerTestHand_MoreThan2Cards_HasntBlackJack() throws 
            PipCard.IncorrectValueException {
        List<Card> cards = Arrays.asList(new PipCard(8), new PipCard(8), 
                new PipCard(5));
        Hand hand = new Hand(cards);
        Player player = new Player("player1", hand);
        assert(!player.hasBlackJack());
    }

    @Test
    public void PlayerTestHand_WithJAndA_HasBlackJack() throws 
            CardWithValueTen.IncorrectLetterException{
        Hand hand1 = new Hand();
        Player player1 = new Player("player1", hand1);
        hand1.addCard(new CardWithValueTen("J"));
        hand1.addCard(new Ace());
        assert(player1.hasBlackJack());
    }
    
    @Test
    public void PlayerTestHand_With5AndA_HasntBlackJack() throws 
            PipCard.IncorrectValueException{
        List<Card> cards = Arrays.asList(new PipCard(5), new Ace());
        Hand hand1 = new Hand(cards);
        Player player1 = new Player("player1", hand1);
        assert(!player1.hasBlackJack());
    }
    
    @Test
    public void PlayerTestWinner_PlayerWithBlackJack() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        List<Card> cards1 = Arrays.asList(new CardWithValueTen("Q"), new Ace());
        Hand hand1 = new Hand(cards1);
        Player player1 = new Player("player1", hand1);
        
        List<Card> cardsC = Arrays.asList(new PipCard(5), new CardWithValueTen("J"));
        Hand handC = new Hand(cardsC);
        Player crupier = new Player("crupier", handC);
        assert(player1.isWinner(crupier));
    }
    
    @Test
    public void PlayerTestWinner_PlayerWithHandSumBiggerThanCrupier() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        List<Card> cards1 = Arrays.asList(new PipCard(5), new CardWithValueTen("K"),
                new PipCard(1));
        Hand hand1 = new Hand(cards1);
        Player player1 = new Player("player1", hand1);
        
        List<Card> cardsC = Arrays.asList(new PipCard(5), new CardWithValueTen("J"));
        Hand handC = new Hand(cardsC);
        Player crupier = new Player("crupier", handC);
        assert(player1.isWinner(crupier));
    }
    
    @Test
    public void PlayerTestWinner_CrupierWithHandSumBiggerThan21() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        List<Card> cards1 = Arrays.asList(new PipCard(5), new CardWithValueTen("K"),
                new PipCard(4));
        Hand hand1 = new Hand(cards1);
        Player player1 = new Player("player1", hand1);
        
        List<Card> cardsC = Arrays.asList(new PipCard(5), new CardWithValueTen("J"),
                new CardWithValueTen("Q"));
        Hand handC = new Hand(cardsC);
        Player crupier = new Player("crupier", handC);
        assert(player1.isWinner(crupier));
    }
    
    @Test
    public void PlayerTestNotWinner_PlayerWithHandSumBigger21() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        List<Card> cards1 = Arrays.asList(new PipCard(5), new PipCard(9),
                new PipCard(8));
        Hand hand1 = new Hand(cards1);
        Player player1 = new Player("player1", hand1);
        
        List<Card> cardsC = Arrays.asList(new PipCard(5), new CardWithValueTen("J"));
        Hand handC = new Hand(cardsC);
        Player crupier = new Player("crupier", handC);
        assert(!player1.isWinner(crupier));
    }
    
    @Test
    public void PlayerTestNotWinner_CrupierWithHandSumBiggerThanPlayer() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        List<Card> cards1 = Arrays.asList(new PipCard(5), new PipCard(9));
        Hand hand1 = new Hand(cards1);
        Player player1 = new Player("player1", hand1);
        
        List<Card> cardsC = Arrays.asList(new PipCard(5), new CardWithValueTen("J"));
        Hand handC = new Hand(cardsC);
        Player crupier = new Player("crupier", handC);
        assert(!player1.isWinner(crupier));
    }
    
    @Test
    public void PlayerTestNotWinner_CrupierWithBlackJack() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        List<Card> cards1 = Arrays.asList(new PipCard(5), new PipCard(9));
        Hand hand1 = new Hand(cards1);
        Player player1 = new Player("player1", hand1);
        
        List<Card> cardsC = Arrays.asList(new CardWithValueTen("K"), new Ace());
        Hand handC = new Hand(cardsC);
        Player crupier = new Player("crupier", handC);
        assert(!player1.isWinner(crupier));
    }
    
    @Test
    public void PlayerTestNotWinner_PlayerAndCrupierSameHandSum() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        List<Card> cards1 = Arrays.asList(new PipCard(8), new PipCard(9));
        Hand hand1 = new Hand(cards1);
        Player player1 = new Player("player1", hand1);
        
        List<Card> cardsC = Arrays.asList(new CardWithValueTen("K"), new PipCard(5), 
                new PipCard(3));
        Hand handC = new Hand(cardsC);
        Player crupier = new Player("crupier", handC);
        assert(!player1.isWinner(crupier));
    }
    
    @Test
    public void PlayerTestString() throws 
            PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        List<Card> cards = Arrays.asList(new PipCard(10), new PipCard(9), new Ace(), 
                new Ace(), new CardWithValueTen("J"));
        Hand hand = new Hand(cards);
        Player player = new Player("player", hand);
        assertEquals("player: 10 9 A A J (31)", player.toString());
    }
    
    
    @Test 
    public void HandTest_DifferentWaysOfInitializing() throws PipCard.IncorrectValueException{
        List<Card> cards = Arrays.asList(new PipCard(8), new PipCard(8), 
                new PipCard(5));
        Hand hand1 = new Hand(cards);
        Hand hand2 = new Hand();
        hand2.addCard(new PipCard(8));
        hand2.addCard(new PipCard(8));
        hand2.addCard(new PipCard(5));
        assertEquals(hand1.toString(), hand2.toString());
    }
    
    @Test 
    public void HandTestSum() throws PipCard.IncorrectValueException{
        List<Card> cards = Arrays.asList(new PipCard(8), new PipCard(8), 
                new PipCard(5));
        Hand hand = new Hand(cards);
        assertEquals(21, hand.getSumHand());
    }
    
    @Test 
    public void HandTestSum_WithAceOver21SecondValue() throws PipCard.IncorrectValueException{
        List<Card> cards = Arrays.asList(new PipCard(10), new PipCard(10), 
                new Ace());
        Hand hand = new Hand(cards);
        assertEquals(21, hand.getSumHand());
    }
    
    @Test 
    public void HandTestSum_WithAce21FirstValue() throws PipCard.IncorrectValueException, 
            CardWithValueTen.IncorrectLetterException{
        List<Card> cards = Arrays.asList(new CardWithValueTen("J"), new Ace());
        Hand hand = new Hand(cards);
        assertEquals(21, hand.getSumHand());
    }
    
    @Test 
    public void HandTestSum_WithAceLess21() throws PipCard.IncorrectValueException{
        List<Card> cards = Arrays.asList(new PipCard(2), new PipCard(3), 
                new Ace());
        Hand hand = new Hand(cards);
        assertEquals(16, hand.getSumHand());
    }
    
    @Test 
    public void HandTestSum_WithMoreThanOneAce_TwoGetSecondValue() 
            throws PipCard.IncorrectValueException{
        List<Card> cards = Arrays.asList(new Ace(), new Ace(), new Ace());
        Hand hand = new Hand(cards);
        assertEquals(13, hand.getSumHand());
    }
    
    @Test 
    public void HandTestSum_WithMoreThanOneAce_AllGetSecondValue() 
            throws PipCard.IncorrectValueException{
        List<Card> cards = Arrays.asList(new PipCard(10), new PipCard(9), new Ace(), 
                new Ace(), new Ace());
        Hand hand = new Hand(cards);
        assertEquals(22, hand.getSumHand());
    }
    
    @Test 
    public void HandTestSize() 
            throws PipCard.IncorrectValueException{
        List<Card> cards = Arrays.asList(new PipCard(10), new PipCard(9), new Ace(), 
                new Ace(), new Ace());
        Hand hand = new Hand(cards);
        assertEquals(5, hand.getSize());
    }
    
    @Test 
    public void HandTestString() 
            throws PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        List<Card> cards = Arrays.asList(new PipCard(10), new PipCard(9), new Ace(), 
                new Ace(), new CardWithValueTen("J"));
        Hand hand = new Hand(cards);
        assertEquals("10 9 A A J ", hand.toString());
    }
    
    @Test 
    public void HandTestAddCard() 
            throws PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        List<Card> cards = Arrays.asList(new PipCard(10), new PipCard(9), new Ace(), 
                new Ace(), new CardWithValueTen("J"));
        Hand hand = new Hand(cards);
        hand.addCard(new PipCard(2));
        assertEquals("10 9 A A J 2 ", hand.toString());
    }
    
    
    @Test 
    public void DeckTestGetCard() 
            throws PipCard.IncorrectValueException, CardWithValueTen.IncorrectLetterException{
        LinkedList<Card> cards = new LinkedList<>(Arrays.asList(new PipCard(10),  
                new Ace(), new CardWithValueTen("J")));
        Deck deck = new Deck(cards);
        assertEquals("10", deck.getCard().toString());
        assertEquals(2, deck.getSize());
    }
    
    
}
