import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class RectanglesGUI
{
	JFrame frame;
	RectangleDrawPanel drawPanel;
	Color color1 = Color.orange;
	Color color2 = Color.blue;
	boolean setCheck = true;

	public static void main (String[] args)
	{
		RectanglesGUI gui = new RectanglesGUI();
		gui.go();
	}

	//this method sets up the JFrame, adds the button and drawpanel to the frame and adds the ActionListener to the button
	public void go()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		drawPanel = new RectangleDrawPanel();
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

		JButton myButton = new JButton("Click here randomise colours");
        frame.getContentPane().add(BorderLayout.SOUTH, myButton);
        myButton.addActionListener(new RandomColorListener());

        JButton resetButton = new JButton("Click here to reset colours!");
        frame.getContentPane().add(BorderLayout.NORTH, resetButton);
        resetButton.addActionListener(new ResetListener());

		frame.setSize(600,600);
		frame.setVisible(true);
	}

	class RectangleDrawPanel extends JPanel{
		public void paintComponent (Graphics g){
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;

            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++){
                    g2.setColor(((i+j)%2 == 0) ? color1 : color2);
                    g2.fill3DRect(i*(getWidth()/5), j*(getHeight()/5), getWidth()/5, getHeight()/5, true);
                }
            }
		}
	}

	class RandomColorListener implements ActionListener{
	    public void actionPerformed (ActionEvent event){

	        Random r = new Random();

            float red = r.nextFloat();
            float green = r.nextFloat();
            float blue = r.nextFloat();
            Color randColor = new Color(red, green, blue);

            if (setCheck){
                color1 = randColor;
                setCheck = !setCheck;
            }else{
                color2 = randColor;
                setCheck = !setCheck;
            }

            frame.repaint();
        }
    }

    class ResetListener implements ActionListener{
        public void actionPerformed (ActionEvent event){

            color1 = Color.orange;
            color2 = Color.blue;

            frame.repaint();
        }
    }


}
