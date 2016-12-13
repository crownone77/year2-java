import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RectanglesGUI
{
	JFrame frame;
	RectangleDrawPanel drawPanel;
	Color color1 = Color.orange;
	Color color2 = Color.blue;

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

		frame.setSize(600,600);
		frame.setVisible(true);
	}

	class RectangleDrawPanel extends JPanel{
		public void paintComponent (Graphics g){
			super.paintComponent(g);
			Graphics2D g2=(Graphics2D)g;
			int width = 100;
			int height = 100;
			g2.setColor(color1);
			g2.fill3DRect(0,0,width,height,true);
			g2.setColor(color2);
			g2.fill3DRect(0,100,width,height,true);
			g2.setColor(color1);
			g2.fill3DRect(0,200,width,height,true);
			g2.setColor(color2);
			g2.fill3DRect(0,300,width,height,true);
			g2.setColor(color1);
			g2.fill3DRect(0,400,width,height,true);

			g2.setColor(color2);
			g2.fill3DRect(100,0,width,height,true);
			g2.setColor(color1);
			g2.fill3DRect(100,100,width,height,true);
			g2.setColor(color2);
			g2.fill3DRect(100,200,width,height,true);
			g2.setColor(color1);
			g2.fill3DRect(100,300,width,height,true);
			g2.setColor(color2);
			g2.fill3DRect(100,400,width,height,true);

			g2.setColor(color1);
			g2.fill3DRect(200,0,width,height,true);
			g2.setColor(color2);
			g2.fill3DRect(200,100,width,height,true);
			g2.setColor(color1);
			g2.fill3DRect(200,200,width,height,true);
			g2.setColor(color2);
			g2.fill3DRect(200,300,width,height,true);
			g2.setColor(color1);
			g2.fill3DRect(200,400,width,height,true);

			g2.setColor(color2);
			g2.fill3DRect(300,0,width,height,true);
			g2.setColor(color1);
			g2.fill3DRect(300,100,width,height,true);
			g2.setColor(color2);
			g2.fill3DRect(300,200,width,height,true);
			g2.setColor(color1);
			g2.fill3DRect(300,300,width,height,true);
			g2.setColor(color2);
			g2.fill3DRect(300,400,width,height,true);

			g2.setColor(color1);
			g2.fill3DRect(400,0,width,height,true);
			g2.setColor(color2);
			g2.fill3DRect(400,100,width,height,true);
			g2.setColor(color1);
			g2.fill3DRect(400,200,width,height,true);
			g2.setColor(color2);
			g2.fill3DRect(400,300,width,height,true);
			g2.setColor(color1);
			g2.fill3DRect(400,400,width,height,true);
		}
	}
}
