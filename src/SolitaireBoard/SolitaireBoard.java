package SolitaireBoard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
/*
  class SolitaireBoard
  The board for Bulgarian Solitaire.  You can change what the total 
  number of cards is for the game by changing NUM_FINAL_PILES, below.  
  Don't change CARD_TOTAL directly, because there are only some values
  for CARD_TOTAL that result in a game that terminates.  (See comments 
  below next to named constant declarations for more details on this.)
*/
public class SolitaireBoard {
   
   public static final int NUM_FINAL_PILES = 9;
   // number of piles in a final configuration
   // (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45) 
   public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
   // bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
   // see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
   // the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES

   // Note to students: you may not use an ArrayList -- see assgt 
   // description for details. 
 
   /**
      Representation invariant:
      <put rep. invar. comment here>
   
   */  
   // <add instance variables here>
   //private ArrayList<Integer> piles;
   private int[] piles = new int[CARD_TOTAL];
   private int currentSize;
  // private Random generator = new Random();
   /**
      Creates a solitaire board with the configuration specified in piles.
      piles has the number of cards in the first pile, then the number of 
      cards in the second pile, etc.
      PRE: piles contains a sequence of positive numbers that sum to 
      SolitaireBoard.CARD_TOTAL
   */
   public SolitaireBoard(ArrayList<Integer> initialPile) {	   	  
	   	  int i=0;
	      for (int s : initialPile)
	      {
	          piles[i] = s;   
	          i++;	    	  
	      }
	      currentSize = i;	     
      // sample assert statement (you will be adding more of these calls)
      // this statement stays at the end of the constructor.
	      assert isValidSolitaireBoard();   
   }
    
   /**
      Creates a solitaire board with a random initial configuration.
   */
   public SolitaireBoard() {	   
	   int cardNum = CARD_TOTAL;
	   
	   while(cardNum>0) {
		   // select a random number between 1 and numCards
		   int randNum = 1+(int)(Math.random() * cardNum);
		   // add number to piles
	       piles[currentSize] = randNum;
	       currentSize++;
	       cardNum -= randNum;	   
	   }
   }
  
   /**
   Play the game.
*/
   public void play()
   {	
	   int i=0;
	   while (!isDone())
       {
		  i++;    	 
    	  playRound();
    	  System.out.println("["+ i +"] Current configuration:" + configString());    	  
       }
	  System.out.println("Done!");   
}
   /**
   	Play one round of the game. 
    */ 
   	/**
      Plays one round of Bulgarian solitaire.  Updates the configuration 
      according to the rules of Bulgarian solitaire: Takes one card from each
      pile, and puts them all together in a new pile.
      The old piles that are left will be in the same relative order as before, 
      and the new pile will be at the end.
   */
   public void playRound() {
	   //ArrayList<Integer> nextList = new ArrayList<Integer>();
	   int newPile = 0;  //build new pile
	   
	   int[] newPiles = new int[CARD_TOTAL];     
	   int i=0;
	   for(int count=0; count<currentSize; count++) {
		   piles[count] = piles[count]-1;
		   newPile++;
		   
		   if(piles[count]>0) {
			   newPiles[i] = piles[count];
			   i++;
		   }
	   }
	   currentSize = i+1;
	   newPiles[currentSize-1] = newPile;
	   piles = newPiles;    	   	 
   }
   
   /**
      Returns true iff the current board is at the end of the game.  That is, 
      there are NUM_FINAL_PILES piles that are of sizes 
      1, 2, 3, . . . , NUM_FINAL_PILES, 
      in any order.
   */ 
   public boolean isDone() {
	  boolean result = true;
	  
	  int[] newArr = new int[] {1,2,3,4,5,6,7,8,9};	 //base array 
      if(currentSize != NUM_FINAL_PILES) {
    	  result = false;
      }
      else {
    	  int[] newArr2 = new int[NUM_FINAL_PILES];   //build new array of length 9
    	  for(int i=0; i<NUM_FINAL_PILES; i++) {
    		  newArr2[i] = piles[i];
    	  }
    	  Arrays.sort(newArr2);       //sort every array
    	  for(int i=0; i<NUM_FINAL_PILES; i++) {
    		  if(newArr2[i] != newArr[i]) {     //compare every array to base array
    			  result = false;
    			  break;
    		  }
    	  }
      }
      return result;  // dummy code to get stub to compile     
   }  
   
   /*
      Returns current board configuration as a string with the format of
      a space-separated list of numbers with no leading or trailing spaces.
      The numbers represent the number of cards in each non-empty pile.
   */
   public String configString()
   {
       String set = " ";
       for(int i=0; i<currentSize; i++) {
    	   set += piles[i] + " "; 
       }           
       return set;
   }
   
   /*
      Returns true iff the solitaire board data is in a valid state
      (See representation invariant comment for more details.)
   */
   private boolean isValidSolitaireBoard() {
	 
      return !isDone();  // dummy code to get stub to compile
   }
}
