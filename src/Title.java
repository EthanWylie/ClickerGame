import javax.swing.*;
import java.awt.*;

public class Title {
    JFrame jFrame;
    JPanel jPanel = new JPanel();
    JButton jButtonStart, jButtonOptions;
    JLabel jLabel;

    void window(){
        jFrame = new JFrame("Clicker Game Menu");

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(300, 300);
        jFrame.setLayout(null);
        jPanel.setSize(300, 300);
        jFrame.add(jPanel);
        buttons();
        title();
    }

    void title(){
        jLabel = new JLabel("Menu");

        jLabel.setFont(new Font("Times new Roman", Font.PLAIN, 28));
        jLabel.setForeground(Color.BLACK);
        jLabel.setBounds(108, 20, 200, 50);
        jPanel.add(jLabel);

    }

    void buttons(){
        jButtonStart = new JButton("Start");
        jButtonOptions = new JButton("Options");

        jPanel.setLayout(null);

        jButtonStart.setBounds(100, 200, 100, 50);
        jButtonStart.setBackground(Color.green);
        jButtonStart.setForeground(Color.BLACK);

        jButtonOptions.setBounds(100, 100, 100, 50);
        jButtonOptions.setBackground(Color.green);
        jButtonOptions.setForeground(Color.BLACK);

        jButtonOptions.addActionListener(e -> {
            System.out.println("test");
        });
        
        // If start button pressed it'll close the title window and open the main game
        jButtonStart.addActionListener(e -> {
            jPanel.removeAll();
            jPanel.revalidate();
            jPanel.repaint();
            jFrame.setVisible(false);
            new ClickerGame().window();
        });
        jPanel.add(jButtonStart);
        jPanel.add(jButtonOptions);
    }

}
