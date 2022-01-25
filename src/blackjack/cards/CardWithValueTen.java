package blackjack.cards;

public class CardWithValueTen extends Card {
    
    private final String letter;

    public CardWithValueTen(String letter) throws IncorrectLetterException {
        if (letter.equals("J") || letter.equals("Q") || letter.equals("K")){
            this.letter = letter;
        }
        else{
            throw new IncorrectLetterException();
        }
    }

    public String getLetter() {
        return letter;
    }

    @Override
    public int value() {
        return 10;
    }

    @Override
    public String toString() {
        return getLetter();
    }
    
    public static class IncorrectLetterException extends Exception {
        public IncorrectLetterException() {
            super("Letter of the card is incorrect must be or J or Q or K");
        }
    }

}
