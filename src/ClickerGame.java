import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;

public class ClickerGame {
    JFrame jFrame;
    JPanel jPanel = new JPanel();
    JButton jButton;
    JLabel jLabel, buttonPressedTextLabel;
    public int clickCount = 0;
    public Music music = new Music();
    void window(){
        jFrame = new JFrame("Clicker Game");

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(600, 600);
        jFrame.setLayout(null);
        jPanel.setSize(600, 600);
        jFrame.add(jPanel);
        buttonPressedText();

        Shop shop = new Shop(jPanel, this);
        shop.shopButton();

        music.music();
        music.clip.start();
        music.clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    void buttonPressedText() {
        buttonPressedTextLabel = new JLabel("Clicks $" + clickCount);
        buttonPressedTextLabel.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        buttonPressedTextLabel.setForeground(Color.BLACK);
        jPanel.setLayout(null);
        buttonPressedTextLabel.setBounds(10, 10, 200, 20); // Set the position and dimensions of the label
        jPanel.add(buttonPressedTextLabel);

        jFrame.validate();
        jFrame.repaint();
        amount();
    }

    void amount(){
        jLabel = new JLabel();
        jLabel.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        jLabel.setForeground(Color.BLACK);
        jPanel.setLayout(null);
        jLabel.setBounds(10, 10, 200, 20); // Set the position and dimensions of the label
        jPanel.add(jLabel);

        jFrame.validate();
        jFrame.repaint();
        button();
    }

    void button(){
        jButton = new JButton("Button");
        jButton.setBackground(Color.GREEN);
        jButton.setForeground(Color.BLACK);
        jButton.setBounds(200,500,200,50);

        jButton.addActionListener(e -> {
            clickCount++;
            jLabel.setText("Clicks $" + clickCount);
            buttonPressedTextLabel.setVisible(false);



        });

        jPanel.add(jButton);
    }

    public void addClicks(int clicks){
        clickCount += clicks;
        jLabel.setText("Clicks $" + clickCount);
    }
}
