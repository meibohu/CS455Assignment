//Name:
//USC NetID:
//CS 455 PA1
//Fall 2019

/**
* class CoinTossSimulator
* 
* Simulates trials of repeatedly tossing two coins and allows the user to access the
* cumulative results.
* 
* NOTE: we have provided the public interface for this class.  Do not change
* the public interface.  You can add private instance variables, constants, 
* and private methods to the class.  You will also be completing the 
* implementation of the methods given. 
* 
* Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
* 
*/
package Coin;

import java.util.Random;

public class CoinTossSimulator {
	private static int head = 0;
	private static int tail = 1;      //there are two possibilities.
	
	private int numTrials;
	private int two_head;
	private int two_tail;
	private int head_tail;
/**
   Creates a coin toss simulator with no trials done yet.
*/
	public CoinTossSimulator() {
		numTrials = 0;
		two_head = 0;
		two_tail = 0;
		head_tail = 0;
	}


/**
   Runs the simulation for numTrials more trials. Multiple calls to this method
   without a reset() between them *add* these trials to the current simulation.
   
   @param numTrials  number of trials to for simulation; must be >= 1
 */
	public void run(int numTrials) {
		Random rand = new Random();
				
		for(int i=0;i<numTrials;i++) {
			int rand_int1 = rand.nextInt(2);  
	        int rand_int2 = rand.nextInt(2); 
	        
	        if(rand_int1 == rand_int2) {
	        	if(rand_int1 == head) {
	        		two_head++ ;            //when getting head twice.
	        	}
	        	if(rand_int1 == tail) {
	        		two_tail++;        //when getting tail twice;
	        	}
	        }else { 
	        	head_tail++;         //when getting head once and tail once;
	        }
	        this.numTrials = two_head + two_tail + head_tail;
	        
		}       
	}
/**
   Get number of trials performed since last reset.
*/
	public int getNumTrials() {
		return numTrials; // DUMMY CODE TO GET IT TO COMPILE
	}
/**
   Get number of trials that came up two heads since last reset.
*/
	public int getTwoHeads() {
	    return two_head; // DUMMY CODE TO GET IT TO COMPILE
	}
/**
  Get number of trials that came up two tails since last reset.
*/  
	public int getTwoTails() {
	    return two_tail; // DUMMY CODE TO GET IT TO COMPILE
	}
/**
  Get number of trials that came up one head and one tail since last reset.
*/
	public int getHeadTails() {
	    return head_tail; // DUMMY CODE TO GET IT TO COMPILE
	}
/**
   Resets the simulation, so that subsequent runs start from 0 trials done.
 */
	public void reset() {
		two_head = 0;
		two_tail = 0;
		head_tail = 0;
		numTrials = 0;	
	}
	
}

