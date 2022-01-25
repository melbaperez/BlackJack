package blackjack.cards;

public class Ace extends Card{
    
    public Ace(){
        super();
    }

    @Override
    public int value() {
        return 11;
    }
    
    public int secondValue() {
        return 1;
    }
    
    @Override
    public String toString() {
        return "A";
    }

}
