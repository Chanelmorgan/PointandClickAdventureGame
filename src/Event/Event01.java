package Event;

import Main.GameManger;

public class Event01 {
    GameManger gm;

    public Event01(GameManger gm){
        this.gm = gm;
    }

    public void lookHut(){
        gm.ui.messageText.setText("This is your house");

    }

    public void talkHut(){
        gm.ui.messageText.setText("Who are you talking to? ");

    }

    public void restHut(){
        gm.ui.messageText.setText("You rest at the hose. \nYour life has recovered");
    }


}
