package Event;

import Main.GameManger;

public class Event01 {
    GameManger gm;

    public Event01(GameManger gm){
        this.gm = gm;
    }

    public void lookHut(){
        gm.ui.messageText.setText("This is your house.");

    }

    public void talkHut(){
        gm.ui.messageText.setText("Who are you talking to? ");

    }

    public void restHut(){
        gm.ui.messageText.setText("You rest at the house. \nYour life has recovered.");
    }

    public void lookChest(){
        gm.ui.messageText.setText("A chest is on the ground.");
    }

    public void talkChest(){
        gm.ui.messageText.setText("You talk to the best but it says nothing.");
    }

    public void openChest(){
        gm.ui.messageText.setText("You open the chest and find a sword!");
    }

    public void lookGuard(){
        gm.ui.messageText.setText("A guard is standing in front of you.");
    }

    public void attackGuard(){
        gm.ui.messageText.setText("Guard: Hey, don't be stupid!");
    }
    public void talkGuard(){
        gm.ui.messageText.setText("Guard: Don't go any further without a weapon!\nYou should check the chest over there! ");
    }


}
