package Event;

import Main.GameManger;

public class Event02 {
    GameManger gm;

    public Event02(GameManger gm){
        this.gm = gm;

    }

    public void lookCave(){
        gm.ui.messageText.setText("It's a cave!");

    }

    public void talkCave(){
        gm.ui.messageText.setText("YOu hear the echo of your voice");

    }

    public void enterCave(){
        gm.ui.messageText.setText("It's too dark to enter");

    }

    public void lookRoot(){
        gm.ui.messageText.setText("Thers's something at the tree");

    }

    public void talkRoot(){
        gm.ui.messageText.setText("They say plant grows well if you talk to but this tree doesn't look like it needs encouragement");

    }

    public void searchRoot(){
        gm.ui.messageText.setText("You find a lantern!");

    }
}
