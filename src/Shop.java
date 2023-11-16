import javax.swing.*;
import java.awt.*;

public class Shop {
    JButton shopButton, multiplierX2, multiplierX3, shopClose, multiplierX5;
    JPanel jPanel, shopPanel;
    ClickerGame clickerGame;
    boolean isMultiplierPurchasedX2 = false;
    boolean isMultiplierPurchasedX3 = false;
    boolean isMultiplierPurchasedX5 = false;

    public Shop(JPanel jPanel, ClickerGame clickerGame) {
        this.jPanel = jPanel;
        this.clickerGame = clickerGame;
    }

    public void shopButton() {
        shopButton = new JButton("Shop");
        shopButton.setBackground(Color.LIGHT_GRAY);
        shopButton.setForeground(Color.BLACK);
        shopButton.setBounds(10, 40, 100, 50);

        shopButton.addActionListener(e -> {
            shopButton.setVisible(false);
            shopOptions();
            shopPanel.setVisible(true);
        });

        jPanel.add(shopButton);
    }

    void shopOptions() {
        // Define variables
        shopPanel = new JPanel();
        shopPanel.setBackground(Color.BLACK);
        shopPanel.setLayout(null);
        shopPanel.setBounds(10, 40, 300, 400);
        shopClose = new JButton("Close");

        // Create multipliers
        multiplierX2 = new JButton("-$10 clicks for x2");
        multiplierX3 = new JButton("-$100 clicks for x3");
        multiplierX5 = new JButton("-$1000 clicks for x5");


        multiplierX2.setBounds(10, 40, 200, 50);
        multiplierX3.setBounds(10, 100, 200, 50);
        multiplierX5.setBounds(10, 180, 200, 50);
        shopClose.setBounds(190, 340, 100, 50);

        multiplierX2.setBackground(Color.WHITE);
        multiplierX2.setForeground(Color.BLACK);
        multiplierX3.setBackground(Color.WHITE);
        multiplierX3.setForeground(Color.BLACK);
        multiplierX5.setBackground(Color.WHITE);
        multiplierX5.setForeground(Color.BLACK);
        shopClose.setBackground(Color.WHITE);
        shopClose.setForeground(Color.BLACK);

        // Create multiplier functions
        multiplierX2.addActionListener(e -> {
            if (!isMultiplierPurchasedX2 && clickerGame.clickCount >= 10) {
                clickerGame.clickCount -= 10;
                clickerGame.addClicks(2);
                isMultiplierPurchasedX2 = true;
                multiplierX2.setVisible(false);
                clickerGame.jButton.setText("Button (x2)");
                clickerGame.jButton.addActionListener(e1 -> {
                    clickerGame.clickCount += 1;
                    clickerGame.jLabel.setText("Clicks $" + clickerGame.clickCount);
                    clickerGame.buttonPressedTextLabel.setVisible(false);
                });
            } else if (isMultiplierPurchasedX2) {
                System.out.println("Multiplier already purchased");
                multiplierX2.setVisible(false);
            } else {
                System.out.println("Not enough clicks");
            }
        });

        multiplierX3.addActionListener(e -> {
            if (!isMultiplierPurchasedX3 && clickerGame.clickCount >= 100){
                clickerGame.clickCount -= 100;
                clickerGame.addClicks(3);
                isMultiplierPurchasedX3 = true;
                multiplierX3.setVisible(false);
                clickerGame.jButton.setText("Button (x3)");
                clickerGame.jButton.addActionListener(e2 -> {
                    clickerGame.clickCount += 1;
                    clickerGame.jLabel.setText("Clicks $" + clickerGame.clickCount);
                    clickerGame.buttonPressedTextLabel.setVisible(false);
                });
            } else if (isMultiplierPurchasedX3){
                System.out.println("Multiplier already purchased");
                multiplierX3.setVisible(false);
            } else{
                System.out.println("Not enough clicks");
            }
        });

        multiplierX5.addActionListener(e -> {
            if (!isMultiplierPurchasedX5 && clickerGame.clickCount >= 1000){
                clickerGame.clickCount -= 1000;
                clickerGame.addClicks(5);
                isMultiplierPurchasedX5 = true;
                multiplierX5.setVisible(false);
                clickerGame.jButton.setText("Button (x5)");
                clickerGame.jButton.addActionListener(e3 -> {
                    clickerGame.clickCount += 2;
                    clickerGame.jLabel.setText("Clicks $" + clickerGame.clickCount);
                    clickerGame.buttonPressedTextLabel.setVisible(false);
                });
            } else if (isMultiplierPurchasedX5) {
                System.out.println("Multiplier already purchased");
                multiplierX5.setVisible(false);
            }else{
                System.out.println("Not enough clicks");
            }
        });

        shopClose.addActionListener(e -> {
            shopPanel.setVisible(false);
            shopButton.setVisible(true);
        });

        shopPanel.add(multiplierX2);
        shopPanel.add(multiplierX3);
        shopPanel.add(multiplierX5);

        // check if player had brought multiplier
        multiplierX2.setVisible(!isMultiplierPurchasedX2);
        multiplierX3.setVisible(!isMultiplierPurchasedX3);
        multiplierX5.setVisible(!isMultiplierPurchasedX5);
        shopPanel.add(shopClose);

        jPanel.add(shopPanel);
        jPanel.revalidate();
        jPanel.repaint();
    }
}
