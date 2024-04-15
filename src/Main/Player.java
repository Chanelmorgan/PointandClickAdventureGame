package Main;

public class Player {

    // Class variables
    GameManger gm;
    public int playerMaxLife;
    public int playerLife;
    public int hasSword;
    public int hasShield;
    public int hasLantern;


    // Constructor
    public Player(GameManger gm){
        this.gm = gm;
    }

    public void setPlayerDefaultStatus(){
        playerMaxLife = 5;
        playerLife = 3;
        hasSword = 0; // 0 = false, 1 = true
        hasLantern = 0;
        hasShield = 0;
        updatePlayerStatus();
    }

    public void updatePlayerStatus(){
        // Remove all life icon
        int i = 1;
        while(i <6) {
            gm.ui.lifeLabel[i].setVisible(false);
            i++;
        }

        int lifeCount = playerLife;
        while(lifeCount != 0) {
            gm.ui.lifeLabel[lifeCount].setVisible(true);
            lifeCount--;
        }

        // Check player items
        if(hasSword == 0){
            gm.ui.swordLabel.setVisible(false);
        }
        if(hasSword == 1){
            gm.ui.swordLabel.setVisible(true);
        }


        if(hasShield == 0){
            gm.ui.shieldLabel.setVisible(false);
        }
        if(hasShield == 1){
            gm.ui.shieldLabel.setVisible(true);
        }

        if(hasLantern == 0){
            gm.ui.lanternLabel.setVisible(false);
        }
        if(hasLantern == 1){
            gm.ui.lanternLabel.setVisible(true);
        }



    }
}
