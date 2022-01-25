package tests;

import blackjack.cards.Ace;
import blackjack.cards.CardWithValueTen;
import blackjack.cards.PipCard;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CardsTest {
    
    @Test 
    public void AceTestValue(){
        Ace ace = new Ace();
        assertEquals(11, ace.value());
    }
    
    @Test 
    public void AceTestSecondValue(){
        Ace ace = new Ace();
        assertEquals(1, ace.secondValue());
    }
    
    @Test 
    public void AceTestString(){
        Ace ace = new Ace();
        assertEquals("A", ace.toString());
    }
    
    @Test 
    public void CardWithValueTenTestValue() throws CardWithValueTen.IncorrectLetterException{
        CardWithValueTen jack = new CardWithValueTen("J");
        assertEquals(10, jack.value());
        
        CardWithValueTen king = new CardWithValueTen("K");
        assertEquals(10, king.value());
        
        CardWithValueTen queen = new CardWithValueTen("Q");
        assertEquals(10, queen.value());
    }
    
    @Test 
    public void CardWithValueTenTestIncorrectLetter() {
        try{
            CardWithValueTen cardWithValueTenIncorrect = new CardWithValueTen("A");
        }
        catch (CardWithValueTen.IncorrectLetterException e){}
    }
    
    @Test 
    public void CardWithValueTenTestString() throws CardWithValueTen.IncorrectLetterException{
        CardWithValueTen jack = new CardWithValueTen("J");
        assertEquals("J", jack.toString());
        
        CardWithValueTen king = new CardWithValueTen("K");
        assertEquals("K", king.toString());
        
        CardWithValueTen queen = new CardWithValueTen("Q");
        assertEquals("Q", queen.toString());
    }
    
    @Test 
    public void PipCardTestValue() throws PipCard.IncorrectValueException {
        for (int i=2; i<11; i++){
            PipCard pipCard = new PipCard(i);
            assertEquals(i, pipCard.value());
        }
    }
    
    @Test 
    public void PipCardTestIncorrectInputLower() {
        try{
            PipCard pipCard = new PipCard(1);
        }
        catch (PipCard.IncorrectValueException e){}
    }
    
    @Test 
    public void PipCardTestIncorrectInputHigher() {
        try{
            PipCard pipCard = new PipCard(11);
        }
        catch (PipCard.IncorrectValueException e){}
    }
    
}
