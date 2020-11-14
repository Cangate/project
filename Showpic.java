package project;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Showpic extends JPanel implements Runnable {

    private ImageIcon img; 
    static String pic;    
    private String name = ""; 
    private boolean a = false; 
    static Thread draw; 
   
    public Showpic() {
        setBounds(400, 0, 600, 1000);
        setBackground(Color.red);
        draw = new Thread(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        if (a) {
            repaint();
            validate();
            img = new ImageIcon(pic);
            g.drawImage(img.getImage(), 400, 50, this);
            this.a = false;
            validate();
        }
    }

    @Override
    public void run() {
        while (true) {
            validate();
            if (pic != null && !this.a) {
                if (pic != this.name) {
                    img = null;
                    this.name = pic;
                    repaint();
                    validate();
                    this.a = true;
                }
            }
        }
    } 

}
