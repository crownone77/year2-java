import javax.swing.*;
import java.awt.*;

/**
 * Created by steven on 6/12/16.
 */
public class GPanel extends JPanel{

    public void paintComponent(Graphics g){
        int width = this.getWidth();
        int height = this.getHeight();
        int diameter = 40;
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;

        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.GREEN);
        g.fillOval(x, y, diameter, diameter);

        g.setColor(Color.BLUE);
        g.fillOval(0, 0, diameter, diameter);

        g.setColor(Color.BLUE);
        g.fillOval(0, (height - diameter), diameter, diameter);

        g.setColor(Color.BLUE);
        g.fillOval((width - diameter), 0, diameter, diameter);

        g.setColor(Color.BLUE);
        g.fillOval((width - diameter), (height - diameter), diameter, diameter);
    }

}
