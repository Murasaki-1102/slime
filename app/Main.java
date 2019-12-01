package app;
// import java.util.Scanner;
// import actor.Actor;
import actor.Enemy;
import actor.Slime;
import buttle.*;
import setup.*;

/**
 * ----todoist----
 * アイテムの使用→進化
 * 進化後の得意な手
 * ルーチンの実装（gitにサンプルあり）
 * ----次回までにここまで----
 * エンディング整える（可能なら）
 * レイアウト組み立てなおす
 * ----ゴールド目標----
 */

// import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {

        //String name = ShowRule.slimeBorn();
        ShowRule.showRule();
        Dungeon.setDungeon();
        Dungeon.displayGame();
        // Janken.janken(slime, solder1);
        // Buttle.doButtle(slime, solder1);

    }
}
