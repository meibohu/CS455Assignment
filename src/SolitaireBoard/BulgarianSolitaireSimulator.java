package SolitaireBoard;
import java.util.ArrayList;
import java.util.Scanner;
/**
<add main program comment here>
*/
public class BulgarianSolitaireSimulator {
	
	public static void main(String[] args) {
	  
	   boolean singleStep = false;
	   boolean userConfig = false;	
	   for (int i = 0; i < args.length; i++) {
	      if (args[i].equals("-u")) {
	         userConfig = true;
	      }
	      else if (args[i].equals("-s")) {
	         singleStep = true;
	      }}
	
	   // <add code here> 	      	   
	   //(1)    //-u option	   	   
	/*  Scanner in = new Scanner(System.in); 
	    System.out.println("Number of total cards is 45.");
	    System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).");
	    
	    ArrayList<Integer> list = readAndValidateString(in);
	    while(!inputJudge(list)) {
	    	System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be 45");
	    	list = readAndValidateString(in);	    //input list 		    
	    }   
	    SolitaireBoard deck = new SolitaireBoard(list);  */

//	    SolitaireBoard deck = new SolitaireBoard(list);
//	    function1(deck);    
	    SolitaireBoard deck;
	    if(userConfig==true) {
	    	 deck = user();   	   	     
	    }else {
	    	 deck = new SolitaireBoard();
	    }
	    if(singleStep==true) {	    	 
	    	single(deck);
	    }else {
	    	function1(deck);
	    }
	 // System.out.println("Initial configuration:" + deck.configString());	 	    
	 // deck.play();
	  //SolitaireBoard deck = user();   
	 // single(deck);
	    
	    //(2)   
	   //SolitaireBoard deck = new SolitaireBoard();   //a random configuration.
	   //System.out.println("Initial configuration:" + deck.configString() );	      
	      //deck.play();
	      //function1(deck);
	  //    single(deck);
	      
	    //(3)
	/*    int i=0;        //the -s option
	    while(!deck.isDone()) {
	    	i++;
	    	Scanner s = new Scanner(System.in);
	    	deck.playRound();	  
	    	System.out.println("["+ i +"] Current configuration:" + deck.configString());
	    	System.out.print("<Type return to continue>");
	    	s.nextLine();		    	
	    }
	    System.out.println("Done!");
	     	     */
	}

	// <add private static methods here>
	//input and transfer string to arraylist.
	 private static ArrayList<Integer> readAndValidateString (Scanner in) { 
	      // don't create another Scanner for Sytem.in here; use the parameter instead
		 ArrayList<Integer> list = new ArrayList<>();
		 String string = "";
        // Scanner in = new Scanner(System.in);
         System.out.println("Please enter a space-separated list of positive integers followed by newline: ");
         
         if(in.hasNextLine()){
             string = in.nextLine();
         }

         Scanner out = new Scanner(string).useDelimiter(" ");

         while(out.hasNextInt()){
             int a = out.nextInt();
             list.add(a);
         }
         //System.out.println("The numbers were "+ list);
	     return list;
	   }
	 //don't stop until the game is done.
	 public static void function1(SolitaireBoard deck) {
		System.out.println("Initial configuration:" + deck.configString());	 
		    
		deck.play();
	 }
	 
	 //Stops between every round of the game. The game only continues when the user hits enter (a.k.a., return).
	 private static void single(SolitaireBoard deck) {       //-c module
		  System.out.println("Initial configuration:" + deck.configString());	
		  int i=0;        //the -s option
		  while(!deck.isDone()) {
		    	i++;
		    	Scanner s = new Scanner(System.in);
		    	deck.playRound();	  
		    	System.out.println("["+ i +"] Current configuration:" + deck.configString());
		    	System.out.print("<Type return to continue>");
		    	s.nextLine();		    	
		  }
		  System.out.println("Done!");
	}
	 
	 //Prompts for the initial configuration from the user, instead of generating a random configuration.
	 private static SolitaireBoard user() {   //-u module
		 Scanner in = new Scanner(System.in); 
		 System.out.println("Number of total cards is 45.");
		 System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).");
		    
		 ArrayList<Integer> list = readAndValidateString(in);
		 while(!inputJudge(list)) {            
			 System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be 45");
		     list = readAndValidateString(in);	    //input list 		    
		 }   
		 SolitaireBoard deck = new SolitaireBoard(list); 
		 return deck;

//		    SolitaireBoard deck = new SolitaireBoard(list);
	 }
	  //judge if input satisfies conditions.
	 private static boolean inputJudge(ArrayList<Integer> list) {
		      int sum = 0;
		      boolean result = true;
		      for(int s: list) {
			 if(s<=0) {      //non-positive numbers
				  result = false;
				  break;
			 }
			 sum += s;
		      }   
		      if(sum!=45) {    //sum is not equal to 45.
			  result = false;
		      }   
		      return result;		 
	 }
}

