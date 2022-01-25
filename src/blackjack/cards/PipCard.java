package blackjack.cards;

public class PipCard extends Card{
    private final int value;

    public PipCard(int value) throws IncorrectValueException {
        if (value >= 2 || value <=10){
            this.value = value;
        }
        else{
            throw new IncorrectValueException();
        }
    }
    
    @Override
    public int value() {
        return this.value;
    }
    
    
    public static class IncorrectValueException extends Exception {
        public IncorrectValueException() {
            super("Value out of range, the value of the pip card has to be "
                    + "between 2 and 10");
        }
    }
    
    @Override
    public String toString() {
        return value() + "";
    }

}
