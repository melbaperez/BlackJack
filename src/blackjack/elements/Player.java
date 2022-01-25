package blackjack.elements;

public class Player {
    private final Hand hand;
    private final String namePlayer;
    
    public Player(String namePlayer, Hand hand) {
        this.namePlayer = namePlayer;
        this.hand = hand;
    }
    
    public Hand getHand(){
        return this.hand;
    }
    
    public String getNamePlayer() {
        return namePlayer;
    }
    
    @Override
    public String toString(){
        return getNamePlayer() + ": " + hand.toString() + "(" + 
                hand.getSumHand() + ")";
    }

    public boolean isWinner(Player crupier) {
        int sumBetCrupier= crupier.getHand().getSumHand();
        int sumBetPlayer= this.getHand().getSumHand();
        
        if (this.hasBlackJack()) return true;
        
        if (sumBetPlayer <= 21){
            if ((sumBetCrupier > 21) || (sumBetCrupier < sumBetPlayer)){
                return true;
            }       
        }
        return false;
        
    }  
    
    public boolean hasBlackJack(){
        return hand.getSumHand() == 21 && hand.getSize() == 2;
    }

}
