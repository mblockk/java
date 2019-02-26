//
// Video Poker Deck Class
// Author: Michael Block
// UNI: MB4239
//

import java.util.Arrays;


public class Deck {
	
	private Card[] cards = new Card[52];
	private int top; 
	int suit;
    int rank;

	
	public Deck(){
        top = 0;
        int i = 0;
            for(int j=1;j<14;j++)
                for(int k=1;k<5;k++)
                cards[i++]= new Card(k,j);                                                                           
    }
	
	public void shuffle(){    // selects two random cards and swaps them
		int a;
        int x;
        System.out.println("");
		System.out.println("Shuffling...");
        System.out.println("...");
        for(int i=0; i<1988; i++){
        x = (int) (52*Math.random());
        a = (int) (52*Math.random());
		Card placeHolder = cards[x];
            cards[x] = cards[a];
            cards[a] = placeHolder;
        }
	}
	
	public Card deal(){
        Card c = cards[top];
        top++;
        return c;  
            		
	}
	
    public String getCards(){
        return Arrays.toString(cards);
    
    }
}