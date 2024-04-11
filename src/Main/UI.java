package Main;

import javax.swing.*;
import java.awt.*;

public class UI {

    GameManger gm;

    JFrame window;
    public JTextArea messageText;


    // Constructor
    public UI(GameManger gm){
        this.gm = gm;

        createMainField();
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
        messageText.setBounds(50, 400, 700, 150);
        messageText.setBackground(Color.BLACK);
        messageText.setForeground(Color.WHITE);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26)); //not working
        window.add(messageText);

    }
}
