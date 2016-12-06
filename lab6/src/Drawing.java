import java.awt.*;
import javax.swing.*;

/**
 * Created by steven on 6/12/16.
 */
public class Drawing{

    public static GPanel gPanel;

    public Drawing(){
        gPanel = new GPanel();
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Drawing d = new Drawing();
    }

}
