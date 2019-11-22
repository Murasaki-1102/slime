package app;
// import java.util.Scanner;

// import actor.Actor;
import actor.Enemy;
import actor.Slime;
import buttle.*;
import setup.*;

// import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {

        Enemy solder1 = new Enemy("兵士A", 12, 4);
        Enemy solder2 = new Enemy("兵士B", 12, 4);
        Enemy solder3 = new Enemy("兵士C", 12, 4);
        String name = ShowRule.slimeBorn();
        Slime slime = new Slime(name, 12, 3);
        ShowRule.showRule();
        Dungeon.setDungeon();
        Dungeon.displayGame();
        // Janken.janken(slime, solder1);
        // Buttle.doButtle(slime, solder1);

    }
}
