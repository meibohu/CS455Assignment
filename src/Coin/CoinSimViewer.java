package Coin;
import java.util.Scanner;
import javax.swing.JFrame;

public class CoinSimViewer {
	public static void main(String[] args) {
		JFrame frame = new JFrame(); 
		frame.setSize(800,500);
	    frame.setTitle("Two Coins");
	    
	    System.out.println("Please enter number of trials: ");
	    Scanner in = new Scanner(System.in);
	    
	    int numTrials = in.nextInt();
	    while (numTrials <= 0) {
            System.out.println("ERROR happens.");
            System.out.print("Enter number of trials: ");
            numTrials = in.nextInt();
        }
	    in.close();
	    CoinSimComponent coinSimComponent = new CoinSimComponent(numTrials);
	   
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    frame.add(coinSimComponent);
	    frame.setVisible(true);
	    	    
	}
}
