package usm;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {

    Thread t;

    Splash() {
        // Set up the image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // Thread initialization
        t = new Thread(this);
        t.start();

        // Initial frame setup
        setUndecorated(true); // Optional: Removes window border for splash effect
        setVisible(true);

        // Animation for splash window
        int x = 1;
        for (int i = 2; i <= 600; i += 4, x += 1) {
            setLocation(600 - ((i + x) / 2), 350 - (i / 2));
            setSize(i + 3 * x, i + x / 2);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(7000); // Show splash for 7 seconds
            setVisible(false);

            // Open next window (Login)
            new Login();
        } catch (Exception e) {
            e.printStackTrace(); // Important for debugging
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
