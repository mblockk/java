//
// Video Poker Player Class
// Author: Michael Block
// UNI: MB4239
//

import java.util.Arrays;
import java.util.ArrayList; 
import java.util.Collections;

public class Player {
			
	private ArrayList<Card> hand = new ArrayList<Card>();
	private double bankroll;
    private double bet;
    public double payOut;
    
		
	public Player(){
        
	    bankroll = 0;
        payOut = 0;
        bet = 0;       
	}
    
    public void inputBankroll(double amount){
   	 	bankroll = amount;
    
    }

    public double getBankroll(){
        
        return bankroll;
    } 
    
    public void bets(double amt){
         bet = amt;
         bankroll -= bet;
    }  
    
	public void addCard(Card c){
         hand.add(c);
	}
    
	public void removeCard(Card c){
	    hand.remove(c);
    }
    
    public void winnings(double odds){
            double multiplier = odds;
            payOut = (bet * multiplier);
            bankroll += payOut;
    }
    
    public void exAdd(int i, Card c){ // sets the exchanged cards to
                                      // their appropriate position		
        hand.set(i, c);
    }
    
    public ArrayList<Card> getHand(){
        
        return hand;
        
    }
    
    public void sortHand(){
        System.out.println("Sorting the hand...");
        Collections.sort(hand);
        
    }
    
    public void printCards(){ // prints player's cards.
                              // the variable i allows them to print
        int i = 1;            // following a number
        System.out.println("");
        for(int j = 0; j<5; j++){
            System.out.println(i + ". " + hand.get(j).toString());
            i++;    
        }

        System.out.println("");
    }
       
    public void makeCard(int a, int b){
        
        Card z = new Card(a,b);
        hand.add(z);
        
    }
    
    public double getPayOut(){
        
        return payOut;    
    }
    
    public void clearHand(){  // clears the player's hand so it can be refilled
                              // without the array list growing to accomodate
        hand.clear();         // more cards being dealt.
         
    }
}    



