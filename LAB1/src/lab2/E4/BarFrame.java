package lab2.E4;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 * A class that implements an Observer object that displays a barchart view of a
 * data model.
 */
public class BarFrame extends JFrame implements ChangeListener {
	private Point mousePoint; // to save the coordinates of button press.
	private double barHeight;
	private double max;

	private ArrayList<Double> a;
	private DataModel dataModel;

	/**
      Constructs a BarFrame object
      @param dataModel the data that is displayed in the barchart
   */
   public BarFrame(DataModel dataModel)
   {
      this.dataModel = dataModel;
      a = dataModel.getData();

      setLocation(0,200);
      setLayout(new BorderLayout());

      final Icon barIcon = new Icon()
      {
         public int getIconWidth() { return ICON_WIDTH; }
         public int getIconHeight() { return ICON_HEIGHT; }
         public void paintIcon(Component c, Graphics g, int x, int y)
         {
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(Color.blue);

            max =  (a.get(0)).doubleValue(); // Horizantal relation. x
            for (Double v : a)
            {
               double val = v.doubleValue();
               if (val > max)
                  max = val;
            }
            // double max = findMax(a);

            barHeight = getIconHeight() / a.size(); // vertical relation. y

            int i = 0;
            for (Double v : a)
            {
               double value = v.doubleValue();

               double barLength = getIconWidth() * value / max; // the unit for one block in x-axes

               Rectangle2D.Double rectangle = new Rectangle2D.Double
                  (0, barHeight * i, barLength, barHeight);
               i++;
               g2.fill(rectangle);
            }
         }
      };

      add(new JLabel(barIcon));

      addMouseListener(new MouseAdapter() {
    	  public void mousePressed(MouseEvent event) {
    		  mousePoint = event.getPoint();
    		  
    		  int x = (int) mousePoint.getX();
    		  int y = (int) mousePoint.getY();
    		  x = (int)(x / (barIcon.getIconWidth() / max));
    		  y = (int) ((y/barHeight));
    		 
    		  updateGraph(y-1, x+1);
    		  
    		  
    		  
    	  }
      });

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);
   }

	

	private void updateGraph(int i, double x) {
		if (i<a.size())
			dataModel.update(i, x);
	}

	/**
	 * Called when the data in the model is changed.
	 * 
	 * @param e the event representing the change
	 */
	public void stateChanged(ChangeEvent e) {
		a = dataModel.getData();
		repaint();
	}

	private static final int ICON_WIDTH = 200;
	private static final int ICON_HEIGHT = 200;
}