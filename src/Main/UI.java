package Main;

import javax.swing.*;
import java.awt.*;

public class UI {

    GameManger gm;

    JFrame window;
    public JTextArea messageText;
    public JPanel bgPanel[] = new JPanel[10];  // if need more than 1 bg images increase this number
    public JLabel bgLabel[] = new JLabel[10];


    // Constructor
    public UI(GameManger gm){
        this.gm = gm;

        createMainField();
        createBackground();

        window.setVisible(true);
    }

    // Creates the main frame
    public void createMainField(){
        window = new JFrame();
        window.setSize(800, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        // Creating and adding the message text
        messageText = new JTextArea("This is sample text ");
        messageText.setBounds(50, 410, 700, 150);
        messageText.setBackground(Color.BLACK);
        messageText.setForeground(Color.WHITE);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26)); //not working
        window.add(messageText);

    }


    public void createBackground(){
        bgPanel[1] = new JPanel();
        bgPanel[1].setBounds(50, 50, 700, 350);
        bgPanel[1].setBackground(null);
        bgPanel[1].setLayout(null);
        window.add(bgPanel[1]);

        // uses to load the images
        bgLabel[1] = new JLabel();
        bgLabel[1].setBounds(0, 0, 700, 350);

        ImageIcon bgIcon  = new ImageIcon(getClass().getClassLoader().getResource("treeLandscape.png"));
        // Get the original image from the ImageIcon
        Image originalImage = bgIcon.getImage();

// Resize the original image to fit within the dimensions of the JLabel
        Image scaledImage = originalImage.getScaledInstance(bgLabel[1].getWidth(), bgLabel[1].getHeight(), Image.SCALE_SMOOTH);

// Create a new ImageIcon from the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

// Set the scaled ImageIcon as the icon of the JLabel
        bgLabel[1].setIcon(scaledIcon);

        bgPanel[1].add(bgLabel[1]);



    }
}
