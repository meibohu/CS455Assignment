package Coin;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

	public class CoinSimComponent extends JComponent{		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
				
		private CoinTossSimulator coinTossSimulator;
		
		private static final Color TWO_HEAD_COLOR = Color.RED;
		private static final Color HEAD_TAIL_COLOR = Color.GREEN;
		private static final Color TWO_TAIL_COLOR = Color.BLUE;
		private int counts;
		private int twoHeads;
		private int twoTails;
		private int headTail;
		private double percentOfTwoHeads;
		private double percentOfTwoTails;
		private double percentOfHeadTail;
				
		
		public CoinSimComponent(int numTrials) {
			coinTossSimulator = new CoinTossSimulator();
			coinTossSimulator.run(numTrials); 
			
		}
		
		public void paintComponent(Graphics g) {
			 Graphics2D g2 = (Graphics2D) g;
			
			 //calculating each number.
			 counts = coinTossSimulator.getNumTrials();
			 twoHeads = coinTossSimulator.getTwoHeads();
			 twoTails = coinTossSimulator.getTwoTails();
			 headTail = coinTossSimulator.getHeadTails();
			 
			 percentOfTwoHeads = (double)twoHeads/counts;
			 percentOfTwoTails = (double)twoTails/counts;
			 percentOfHeadTail = (double)headTail/counts;  
			 
			 //initiating bottom and width for all bars.		
			 int bottom = (int)(getHeight()*0.9);
			 int verticleBuffer = (int)(getHeight() - bottom);    //a fixed value in the program.
			 int width = (int)(getWidth()/18);
			 
			 
			 Rectangle2D labelBounds = g2.getFont().getStringBounds(" ", ((Graphics2D) g2).getFontRenderContext());
			 int labelHeight = (int)labelBounds.getHeight();
			 
			 //getting the pixels per unit has.
			 double scale = (g2.getClipBounds().getMaxY() - labelHeight - 2*verticleBuffer) / counts;  
			 			 
			 int left = (int)((g2.getClipBounds().getMaxX() - 3*width) / 4);   
			 int left1 = left;
			 int left2 = 2*left + width;
			 int left3 = 3*left + 2*width;
			 
			 //labels for three bars.
			 String label1 = "Two Heads: " + twoHeads+"(" + Math.round(percentOfTwoHeads*100) + "%)";
			 String label2 = "A head and A tail: " + headTail + "("+ Math.round(percentOfHeadTail*100) + "%)";
			 String label3 = "Two Tails: " + twoHeads+"(" + Math.round(percentOfTwoTails*100) + "%)";
			 	
			 //building three bars:
			 Bar TwoHeads = new Bar(bottom, left1, width, twoHeads, scale, TWO_HEAD_COLOR, label1);
			 TwoHeads.draw(g2);
			 Bar AheadAtail = new Bar(bottom, left2, width, headTail, scale, HEAD_TAIL_COLOR, label2);
			 AheadAtail.draw(g2);	 
			 Bar TwoTails = new Bar(bottom, left3, width, twoTails, scale, TWO_TAIL_COLOR, label3);
			 TwoTails.draw(g2);					 		 
		}
}
