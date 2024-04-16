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
        if(gm.player.hasLantern==0){
            gm.ui.messageText.setText("It's too dark to enter");
        } else{
            // goes to scene 3
            gm.sChanger.showScene3();
        }


    }

    public void lookRoot(){
        gm.ui.messageText.setText("This is a large tree.");

    }

    public void talkRoot(){
        gm.ui.messageText.setText("They say plant grows well if you talk to but this tree doesn't look like it needs encouragement");

    }

    public void searchRoot(){
        if(gm.player.hasLantern == 0){
            gm.ui.messageText.setText("You find a lantern!");
            gm.player.hasLantern = 1;
            gm.player.updatePlayerStatus();
        } else {
            gm.ui.messageText.setText("You didn't find anything");
        }


    }
}
