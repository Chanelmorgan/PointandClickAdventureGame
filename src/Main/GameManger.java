package Main;

import Event.Event01;

public class GameManger {

    ActionHandler aHandelr = new ActionHandler(this);

    public Event01 ev1 = new Event01(this);

    public UI ui = new UI(this);
    public Player player = new Player(this);
    public SceneChanger sChanger = new SceneChanger(this);

    public static void main(String[] args) {
        new GameManger();
    }

    // Constructor
    public GameManger(){
        player.setPlayerDefaultStatus();
        sChanger.showScene1();

    }

}
