//
// Video Poker Game Class
// Author: Michael Block
// UNI: MB4239
//
 
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Game {

    Scanner ints = new Scanner(System.in); // one scanner for ints
    Scanner dubs = new Scanner(System.in); // one for doubles
	private Player p = new Player();
    private Deck cards = new Deck();
    private double bet;
    private double bankIn;
    public String[] forcedHand = new String[4]; // copies user-inputted hand
    public int args; // this variable is treated tells the method 
                     // as a boolean and tells play() whether to skip
                    // normal gameplay based on a user defined hand
    	
	
    public Game(String[] testHand){
        
        
        args = 0;
        forcedHand = testHand.clone();
        
        for (int i = 0; i < forcedHand.length; i++){
            if (forcedHand[i].contains("h")){
                this.makeH(i); 
            }
        }
        for (int i = 0; i < forcedHand.length; i++){
            if (forcedHand[i].contains("d")){
                this.makeD(i); 
            }
        }
        for (int i = 0; i < forcedHand.length; i++){
            if (forcedHand[i].contains("c")){
                this.makeC(i); 
            }
        }                 
        for (int i = 0; i < forcedHand.length; i++){
            if (forcedHand[i].contains("s")){
                this.makeS(i); 
            }
        }        
        
        args = 1;

    }

    public Game(){
        
        args = 0; 
        bet = 0;
        bankIn = 0;

	}
	
	public void play(){
        
        int selection = -1; // used for the while loop that maintains the
                            // ability to play hand after hand  
                                 	
        this.getWelcome(); // triggers welcome screen method
        
    if(args == 0){ 
                    
        System.out.printf("Please enter your desired bankroll: ");
		bankIn = (int) dubs.nextDouble();
		p.inputBankroll(bankIn);
        dubs.nextLine();
        System.out.println("");
        System.out.println("~~ May the Gods of good fortune shine upon you ~~");
        System.out.println("");
               
        
           
   while (selection !=3 ){  
            if (p.getBankroll() == 0 ) {
            System.out.println("You're out of money. Good luck paying rent!");
            return;
            }
        
            System.out.println("What would you like to do?");
            System.out.println("1 - get current bankroll");
            System.out.println("2 - deal the cards already, buster");
            System.out.println("3 - quit");
            System.out.println("");
            System.out.printf("Your selection: ");

            selection = ints.nextInt();
            ints.nextLine();
            System.out.println("");
            
       if (selection == 1){
            
            System.out.println("Your bankroll ---> " +p.getBankroll());
            System.out.println("");
       }
     
       else if (selection == 2){
       		
            this.betSequence(); // triggers betting        
       
            cards.shuffle();    // shuffles the deck array
			System.out.println("Dealing...");
            System.out.println("...");
            for (int i=0; i<5; i++){
           	p.addCard(cards.deal()); // deals five cards to the player
            }
     
            p.sortHand();
            System.out.println("");
            System.out.println("Your hand is: ");           
			p.printCards();
                       
			this.exchange(); // triggers exchange sequence

            this.checkHand(p.getHand()); // triggers check hand sequence
            
            this.results(this.checkHand(p.getHand())); // triggers method that
                                                       // passes odds and prints
                                                      // the winning/losing statement
            
            p.clearHand();  // clears player's hand                          
            cards = new Deck(); // new deck with each play
            
       }
       else if (selection == 3){
           
           System.out.println("Thanks for playing! Goodbye!");
           System.out.println("");
           return;
       }       
       }
    }
    else{   
         p.sortHand();
         System.out.println("");
         System.out.println("Your hand is: ");           
         p.printCards();
         this.checkHand(p.getHand());
         this.results(this.checkHand(p.getHand()));
        }  
    }                 
    public void getWelcome(){
        String welcome = "";
        String welcome0 = "         *****************************          "
            + System.lineSeparator();
        String welcome1 = "  ********************************************  "
            + System.lineSeparator();
        String welcome2 = " ********************************************** "
            + System.lineSeparator();
		String welcome3 = " ** Welcome to Video Poker by Michael Block  **"
            + System.lineSeparator();       
        String welcome4 = " ********************************************** "
            + System.lineSeparator();
        String welcome5 = "  ********************************************  "
            + System.lineSeparator();
        String welcome6 = "        ** Standard Five Card Draw **           "
            + System.lineSeparator();
        welcome = welcome0+welcome1+welcome2+welcome3+welcome4+welcome5+welcome6;
        
        System.out.println("");
        System.out.println(welcome);
     
    } 
    
    public void betSequence(){
        
        System.out.printf("You can bet 1-5 tokens. What would you like to bet? ");        
        bet = dubs.nextDouble();
        
        while (bet > 5 || bet < 1){
            System.out.println("");
            System.out.println("Please make a valid bet between 1-5");
            System.out.println("");
            System.out.printf("What would you like to bet? ");
            
            bet = (int)dubs.nextDouble();  
              
            while (bet > p.getBankroll()){
                System.out.println("You only have " + p.getBankroll() 
                               + "! Please bet what you can afford! ");
                System.out.printf("What would you like to bet? ");
            
                bet = (int)dubs.nextDouble();  
            
            }
        }  
         p.bets(bet);     
    }
    
    public void exchange(){
        
    Scanner input = new Scanner(System.in);
    System.out.println("How many cards do you want to exchange? (0-5)");
            int choice = input.nextInt();
        
    if (choice == 0){
        System.out.println("");
        System.out.println("Your current hand:");
        p.printCards();
    } 
        
        else{
            int k = 0;
            int exchange[] = new int[choice+1];
            System.out.println("");
            System.out.println("Which cards would you like to exchange?");
			System.out.println("Please enter the corresponding numbers individually");
           	System.out.println("");
        
        for (int i = 1 ; i < exchange.length; i++){
            System.out.printf("Swap: ");
            exchange[k] = input.nextInt()-1;
            
        if (exchange[k] == 0){      
                p.exAdd(0, cards.deal());
            }
            else if (exchange[k] == 1){      
                p.exAdd(1,  cards.deal());
            }

            else if (exchange[k] == 2){      
                p.exAdd(2, cards.deal());
            }

            else if (exchange[k] == 3){      
                p.exAdd(3, cards.deal());
            }

            else if (exchange[k] == 4){      
                p.exAdd(4, cards.deal());
            }

        }
        
        System.out.println("");
        p.sortHand();    
        System.out.println("Your new hand is: ");
        p.printCards();          
    }
    }	
    
	public String checkHand(ArrayList<Card> hand){ // checks each hand and triggers
                                                   // the appropriate boolean
	    ArrayList<Card> thisHand = new ArrayList<Card>(hand);	
        Boolean royalFlush = false;
        Boolean straightFlush = false;
        Boolean fourKind = false;
        Boolean fullHouse = false;
        Boolean flush = false;
        Boolean straight = false;
        Boolean threeKind = false;
        Boolean twoPair = false;
        Boolean onePair = false;
        Boolean womp = false;
        
         
    if (thisHand.get(0).getRank() - thisHand.get(4).getRank() == -12
            && thisHand.get(0).getSuit() == thisHand.get(1).getSuit() 
            && thisHand.get(1).getSuit() == thisHand.get(2).getSuit()
            && thisHand.get(2).getSuit() == thisHand.get(3).getSuit() 
            && thisHand.get(3).getSuit() == thisHand.get(4).getSuit()
            && thisHand.get(0).getRank() != thisHand.get(1).getRank() 
            && thisHand.get(1).getRank() != thisHand.get(2).getRank() 
            && thisHand.get(2).getRank() != thisHand.get(3).getRank() 
            && thisHand.get(3).getRank() != thisHand.get(4).getRank()){ 
                
				royalFlush = true;
            	return "RoyalFlush";
        }
        else if ((thisHand.get(0).getRank() - thisHand.get(4).getRank()) == 4 
            && thisHand.get(0).getSuit() == thisHand.get(1).getSuit() 
            && thisHand.get(1).getSuit() == thisHand.get(2).getSuit()
            && thisHand.get(2).getSuit() == thisHand.get(3).getSuit() 
            && thisHand.get(3).getSuit() == thisHand.get(4).getSuit()
            && thisHand.get(0).getRank() != thisHand.get(1).getRank() 
            && thisHand.get(1).getRank() != thisHand.get(2).getRank() 
            && thisHand.get(2).getRank() != thisHand.get(3).getRank() 
            && thisHand.get(3).getRank() != thisHand.get(4).getRank()){ 
            
				straightFlush = true;
            	return "StraightFlush";
        }
        else if (thisHand.get(0).getRank() == thisHand.get(1).getRank()
                && thisHand.get(1).getRank() == thisHand.get(2).getRank() 
                && thisHand.get(2).getRank() == thisHand.get(3).getRank() 
                || thisHand.get(1).getRank() == thisHand.get(2).getRank()
                && thisHand.get(2).getRank() == thisHand.get(3).getRank()
                && thisHand.get(3).getRank() == thisHand.get(4).getRank()){
                
                fourKind = true;
                return "FourKind";
        }                     
        else if (thisHand.get(0).getRank() == thisHand.get(1).getRank()
                && thisHand.get(1).getRank() == thisHand.get(2).getRank()
                && thisHand.get(3).getRank() == thisHand.get(4).getRank()){
                
                fullHouse = true;
            	return "FullHouse";
        }         
        else if (thisHand.get(2).getRank() == thisHand.get(3).getRank()
                && thisHand.get(3).getRank() == thisHand.get(4).getRank()
				&& thisHand.get(0).getRank() == thisHand.get(1).getRank()){
                
            	fullHouse = true;
            	return "FullHouse";
        }         
        else if (thisHand.get(0).getSuit() == thisHand.get(1).getSuit() 
                && thisHand.get(1).getSuit() == thisHand.get(2).getSuit()
                && thisHand.get(2).getSuit() == thisHand.get(3).getSuit() 
                && thisHand.get(3).getSuit() == thisHand.get(4).getSuit()){
                
                flush = true;
            	return "Flush";
        }         
        else if ((thisHand.get(0).getRank() - thisHand.get(4).getRank()) == 4 
                && thisHand.get(0).getRank() != thisHand.get(1).getRank() 
                && thisHand.get(1).getRank() != thisHand.get(2).getRank() 
                && thisHand.get(2).getRank() != thisHand.get(3).getRank() 
                && thisHand.get(3).getRank() != thisHand.get(4).getRank()){

				straight = true;
                return "Straight";
        }         
        else if (thisHand.get(0).getRank() == thisHand.get(1).getRank()
                && thisHand.get(1).getRank() == thisHand.get(2).getRank()
                || thisHand.get(2).getRank() == thisHand.get(3).getRank()
                && thisHand.get(3).getRank() == thisHand.get(4).getRank()){
                
                threeKind = true;
                return "ThreeKind";
        }         
        else if (thisHand.get(0).getRank() == thisHand.get(1).getRank() 
                && thisHand.get(2).getRank() == thisHand.get(3).getRank() 
                || thisHand.get(0).getRank() == thisHand.get(1).getRank()
                && thisHand.get(3).getRank() == thisHand.get(4).getRank()
                || thisHand.get(1).getRank() == thisHand.get(2).getRank()
                && thisHand.get(3).getRank() == thisHand.get(4).getRank()){
                
                twoPair = true;
                return "TwoPair"; 
        }
        else if (thisHand.get(0).getRank() == thisHand.get(1).getRank() 
                || thisHand.get(1).getRank() == thisHand.get(2).getRank()
                || thisHand.get(2).getRank() == thisHand.get(3).getRank() 
                || thisHand.get(3).getRank() == thisHand.get(4).getRank()){
                
                onePair = true;
                return "OnePair";
        }        
        else{		
             
                womp = true;
                return "Womp";
        }
    }        	                                           			

    public double getBet(){
        return bet;
    }

	public void deal(){
        
        for(int i=0; i<5; i++){
            Card c = cards.deal();
            p.addCard(c);
        }
    }

    public void results(String result){
        String hand = result;
        if (hand == "RoyalFlush"){
            p.winnings(250.0);
            System.out.println("Holy hell you got a Royal Flush and won $" +
                               	p.getPayOut() + "!! You're taking me out to dinner.");
            System.out.println("");
        }
        if (hand == "StraightFlush"){
            p.winnings(50.0);
            System.out.println("Nice job, big shot, you got a Straight Flush " +
                               	"You win " + p.getPayOut());
            System.out.println("");
        }
        if (hand == "FourKind"){
            p.winnings(25.0);
            System.out.println("Four of a kind! You win " + p.getPayOut());
            System.out.println("");
        }
        if (hand == "FullHouse"){
            p.winnings(6.0);
            System.out.println("Full House! You win " + p.getPayOut());
            System.out.println("");
        }
        if (hand == "Flush"){
            p.winnings(5.0);
            System.out.println("Flush! You win " + p.getPayOut());
            System.out.println("");
        }        
        if (hand == "Straight"){
            p.winnings(4.0);
            System.out.println("Straight! You win " + p.getPayOut());
            System.out.println("");
        }       
        if (hand == "ThreeKind"){
            p.winnings(3.0);
            System.out.println("Three of a kind! You win " + p.getPayOut());
            System.out.println("");
        }
        if (hand == "TwoPair"){
            p.winnings(2.0);
            System.out.println("Two Pair! You win " + p.getPayOut());
            System.out.println("");
        }
        if (hand == "OnePair"){
            p.winnings(1.0);
            System.out.println("You got a pair! You win " + p.getPayOut());
            System.out.println("");
        }
        if (hand == "Womp"){
            System.out.println("You got nada! Womp womp womp");
            System.out.println("");
        }
	}
    
    public void makeH(int i){ // explained in the game method
        

            if (forcedHand[i].length() == 3){
                int a = Integer.parseInt(forcedHand[i].substring(1,3));
                p.makeCard(1,a);
            }
            else if(forcedHand[i].length() ==2){
                int a = Integer.parseInt(forcedHand[i].substring(1, 2));
                    p.makeCard(1, a);
            }
        }                                            
    
    
    public void makeD(int i){ // explained in the game method
        

            if (forcedHand[i].length() == 3){
                int a = Integer.parseInt(forcedHand[i].substring(1,3));
                p.makeCard(2,a);
            }
            else if(forcedHand[i].length() ==2){
                int a = Integer.parseInt(forcedHand[i].substring(1, 2));
                    p.makeCard(2, a);
            }
        }                                            
    
    public void makeC(int i){ // explained in the game method
        

            if (forcedHand[i].length() == 3){
                int a = Integer.parseInt(forcedHand[i].substring(1,3));
                p.makeCard(3,a);
            }
            else if(forcedHand[i].length() ==2){
                int a = Integer.parseInt(forcedHand[i].substring(1, 2));
                    p.makeCard(3, a);
            }
                                                    
    }
    
    public void makeS(int i){ // explained in the game method
        

            if (forcedHand[i].length() == 3){
                int a = Integer.parseInt(forcedHand[i].substring(1,3));
                p.makeCard(4,a);
            }
            else if(forcedHand[i].length() ==2){
                int a = Integer.parseInt(forcedHand[i].substring(1, 2));
                    p.makeCard(4, a);
            }
        }                                            
         
}
    
    

