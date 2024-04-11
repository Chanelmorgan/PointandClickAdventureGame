package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    GameManger gm;

    // Constructor
    public ActionHandler(GameManger gm){
        this.gm = gm;

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();

        switch(yourChoice) {
            case"lookHut":
                gm.ui.messageText.setText("This is your house");
                break;
            case "talkHut":
                gm.ui.messageText.setText("Who are you talking to? ");
                break;
            case "rest":
                gm.ui.messageText.setText("You rest at the hose. \nYour life has recovered");
                break;
            case "lookGuard":
                gm.ui.messageText.setText("This is your house");
                break;
            case "talkGuard":
                gm.ui.messageText.setText("This is your house");
                break;
            case "attackGuard":
                gm.ui.messageText.setText("This is your house");
                break;
            case "lookChest":
                gm.ui.messageText.setText("This is your house");
                break;
            case "talkChest":
                gm.ui.messageText.setText("This is your house");
                break;
            case "openChest":
                gm.ui.messageText.setText("This is your house");
                break;
        }

    }
}
