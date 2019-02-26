//
// Video Poker Card Class
// Author: Michael Block
// UNI: MB4239
//


public class Card implements Comparable<Card>{
	
	private int suit; 
	private int rank; 

	
	public Card(int s, int r){
		suit = s;
        rank = r;
	}
	
	public int compareTo(Card c){
        
        
		if (rank > c.rank){
            return 1;
		}
        	else if (rank < c.rank){
                return -1;
		}
            else if (rank == c.rank){
                return 0;
		}
           	else if (suit > c.suit){
                return 1;
		}
            else if (suit < c.suit){
                return -1;
		}
        else{ 
            return 0;
        }
            
	}
  
    public String toString(){
        
    String two = "2 of ";
    String three = "3 of ";
    String four = "4 of ";
    String five = "5 of ";
    String six = "6 of ";
    String seven = "7 of ";
    String eight = "8 of ";
    String nine = "9 of ";
    String ten = "10 of ";
    String jack = "JACK of ";
    String queen = "QUEEN of ";
    String king = "KING of ";
    String ace = "ACE of ";
    String spades = "Spades";
    String clubs = "Clubs";
    String diamonds = "Diamonds";
    String hearts = "Hearts";
    String theSuit = "";
    String theRank = "";
        
        if (rank == 1)
            theRank =  ace;
                else if (rank == 2)
                    theRank = two;
                else if (rank == 3)
                    theRank = three;
                else if (rank == 4)
                    theRank = four;
                else if (rank == 5)
                    theRank = five;
                else if (rank == 6)
                    theRank = six;
                else if (rank == 7)
                    theRank = seven;
                else if (rank == 8)
                    theRank = eight; 
                else if (rank == 9)
                    theRank = nine;
                else if (rank == 10)
                    theRank = ten;
                else if (rank == 11)
                    theRank = jack;
                else if (rank == 12)
                    theRank = queen;
                else if (rank == 13)
                    theRank = king;
                
        if (rank != 0 && suit == 4)
            theSuit = spades;
                else if (rank != 0 && suit == 3)
                    theSuit = clubs;
                else if (rank != 0 && suit == 2)
                    theSuit = diamonds;
                else if (rank != 0 && suit == 1)
                     theSuit = hearts;
            
        String printHand = theRank+theSuit;
        
			return printHand;
	}
    
	public int getRank(){
        
        return rank;
    }
    
	public int getSuit(){
        
        return suit;
    }
    
}
