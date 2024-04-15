package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UI {

    GameManger gm;

    JFrame window;
    public JTextArea messageText;
    public JPanel bgPanel[] = new JPanel[10];  // if need more than 1 bg images increase this number
    public JLabel bgLabel[] = new JLabel[10];

    //PLAYER UI
    JPanel lifePanel;
    JLabel lifeLabel[] = new JLabel[6];
    JPanel inventoryPanel;
    public JLabel swordLabel, shieldLabel, lanternLabel;


    // Constructor
    public UI(GameManger gm){
        this.gm = gm;

        createMainField();
        createPlayerField();
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
        window.setTitle("Adventure Game");

        // Creating and adding the message text
        messageText = new JTextArea("");
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

    public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String fileName, String choice1Name,
                             String choice2Name, String choice3Name, String choice1Command, String choice2Command, String choice3Command){

        // Creating pop menu
        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem menuItem[] = new JMenuItem[4]; // using [1], [2], [3]
        menuItem[1] = new JMenuItem(choice1Name);
        menuItem[1].addActionListener(gm.aHandelr);
        menuItem[1].setActionCommand(choice1Command);
        popMenu.add(menuItem[1]);

        menuItem[2] = new JMenuItem(choice2Name);
        menuItem[2].addActionListener(gm.aHandelr);
        menuItem[2].setActionCommand(choice2Command);
        popMenu.add(menuItem[2]);

        menuItem[3] = new JMenuItem(choice3Name);
        menuItem[3].addActionListener(gm.aHandelr);
        menuItem[3].setActionCommand(choice3Command);
        popMenu.add(menuItem[3]);

        // create objects
        JLabel objectLabel = new JLabel();
        //objectLabel.setBounds(50, 250, 100, 100);
        objectLabel.setBounds(objx, objy, objWidth, objHeight);
//        objectLabel.setOpaque(true);
//        objectLabel.setBackground(Color.blue);
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

        // adding mouse listener to the objects
        objectLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)){
                    popMenu.show(objectLabel, e.getX(), e.getY());
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        bgPanel[bgNum].add(objectLabel);



    }

    public void createArrowButton(int bgNum, int x, int y, int width, int height, String arrowFileName, String command){
        ImageIcon originalArrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));

        // Resize the original arrow image to fit within the dimensions of the button
        Image scaledArrowImage = originalArrowIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Create a new ImageIcon from the scaled image
        ImageIcon scaledArrowIcon = new ImageIcon(scaledArrowImage);

        JButton arrowButton = new JButton();
        arrowButton.setBounds(x, y, width, height);
        arrowButton.setBackground(null);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setFocusPainted(false);
        arrowButton.setIcon(scaledArrowIcon);
        arrowButton.addActionListener(gm.aHandelr);
        arrowButton.setActionCommand(command);
        arrowButton.setBorderPainted(false);

        bgPanel[bgNum].add(arrowButton);

    }

    public void createPlayerField(){
        lifePanel = new JPanel();
        lifePanel.setBounds(50, 0, 250, 50);
        lifePanel.setBackground(Color.blue);
        lifePanel.setLayout(new GridLayout(1,5));
        window.add(lifePanel);

        // Getting the heart image
        ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource("heart.png"));
        Image image = lifeIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        lifeIcon = new ImageIcon(image);

        int i = 1;
        while(i<6) {
            lifeLabel[i] = new JLabel();
            lifeLabel[i].setIcon(lifeIcon);
            lifePanel.add(lifeLabel[i]);
            i++;
        }

        // Creating the inventory panel
        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(650, 0, 100, 50);
        inventoryPanel.setBackground(Color.BLUE);
        inventoryPanel.setLayout(new GridLayout(1, 3));
        window.add(inventoryPanel);

        // Create Items
        swordLabel = new JLabel();




    }

    // SCENE 1
    public void generateScreen(){
        createBackground(1, "treeLandscape.png");
        createObject(1, 440, 300, 50, 50, "guard.png", "Look", "Talk", "Attack", "lookGuard", "talkGuard", "attackGuard");
        createObject(1,50, 260, 100, 100, "hut.png", "Look", "Talk", "Rest", "lookHut", "talkHut", "restHut");
        createObject(1,310, 250, 50, 50, "locked-chest.png", "Look", "Talk", "Open", "lookChest", "talkChest", "openChest");
        createArrowButton(1, 0, 150, 50, 50,"left-arrow.png", "goScene2");
        bgPanel[1].add(bgLabel[1]);

        // Scene 2
        createBackground(2, "cave.jpg");
        createObject(2, 480, 190, 100, 100, "blank.png", "Look", "Talk", "Enter", "lookCave", "talkCave", "tnterCave");
        createObject(2, 50, 220, 200, 50, "blank.png", "Look", "Talk", "Search", "lookRoot", "talkRoot", "searchRoot");
        createArrowButton(2, 650, 150, 50, 50, "right-arrow.png", "goScene1");
        bgPanel[2].add(bgLabel[2]);

    }


}
