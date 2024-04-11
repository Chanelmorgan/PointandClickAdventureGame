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
        generateScreen();

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


    public void createBackground(int bgNum, String bgFileName ){
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(50, 50, 700, 350);
        bgPanel[bgNum].setBackground(null);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);

        // uses to load the images
        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 700, 350);

        ImageIcon bgIcon  = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
        // Get the original image from the ImageIcon
        Image originalImage = bgIcon.getImage();

// Resize the original image to fit within the dimensions of the JLabel
        Image scaledImage = originalImage.getScaledInstance(bgLabel[bgNum].getWidth(), bgLabel[bgNum].getHeight(), Image.SCALE_SMOOTH);

// Create a new ImageIcon from the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

// Set the scaled ImageIcon as the icon of the JLabel
        bgLabel[bgNum].setIcon(scaledIcon);

        bgPanel[bgNum].add(bgLabel[bgNum]);



    }

    public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String fileName){
        JLabel objectLabel = new JLabel();
        //objectLabel.setBounds(50, 250, 100, 100);
        objectLabel.setBounds(objx, objy, objWidth, objHeight);
        // Load the hut image
        ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(fileName));

        // Get the original image from the ImageIcon
        Image originalImage = objectIcon.getImage();

        // Resize the original image to fit within the dimensions of the JLabel
        Image scaledImage = originalImage.getScaledInstance(objectLabel.getWidth(), objectLabel.getHeight(), Image.SCALE_SMOOTH);

        // Create a new ImageIcon from the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Set the scaled ImageIcon as the icon of the JLabel
        objectLabel.setIcon(scaledIcon);

        bgPanel[bgNum].add(objectLabel);
        bgPanel[bgNum].add(bgLabel[1]);


    }

    public void generateScreen(){
        createBackground(1, "treeLandscape.png");
        createObject(1,50, 250, 100, 100, "hut.png");
    }
}
