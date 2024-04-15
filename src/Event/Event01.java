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
        if(gm.player.playerLife != gm.player.playerMaxLife){
            gm.ui.messageText.setText("You rest at the house. \nYour life has recovered.");
            gm.player.playerLife++;
            gm.player.updatePlayerStatus();
        } else {
            gm.ui.messageText.setText("Your life is full. No need to reset");

        }

    }

    public void lookChest(){
        gm.ui.messageText.setText("A chest is on the ground.");
    }

    public void talkChest(){
        gm.ui.messageText.setText("You talk to the best but it says nothing.");
    }

    public void openChest(){
        if(gm.player.hasSword == 0){
            gm.ui.messageText.setText("You open the chest and find a sword!");
            gm.player.hasSword=1;
            gm.player.updatePlayerStatus();
        } else{
            gm.ui.messageText.setText("You already opened the chest, there's nothing inside.");
        }

    }

    public void lookGuard(){
        gm.ui.messageText.setText("A guard is standing in front of you.");
    }

    public void attackGuard(){
        if(gm.player.hasShield == 0){
            if(gm.player.hasSword == 0){
                if(gm.player.playerLife != 1) {
                    gm.ui.messageText.setText("Guard: Hey, don't be stupid!\n The guard hits you back adn your life decreases by 1.");
                    gm.player.playerLife--;
                    gm.player.updatePlayerStatus();
                } else if(gm.player.playerLife == 1){
                    gm.ui.messageText.setText("Guard: What a fool.");
                    gm.player.playerLife--;
                    gm.player.updatePlayerStatus();
                    // end game

                }

            } else if(gm.player.hasSword == 1) {
                gm.ui.messageText.setText("Guard:Ouch!, \nYou have defeat the guard and gotten hsi shield!");
                gm.player.hasShield = 1;
                gm.player.updatePlayerStatus();
            }
            gm.player.updatePlayerStatus();
        } else{
            gm.ui.messageText.setText("Guard: Just leave me alone.");
        }

    }
    public void talkGuard(){
        gm.ui.messageText.setText("Guard: Don't go any further without a weapon!\nYou should check the chest over there! ");
    }


}
