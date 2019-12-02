package app;
// import java.util.Scanner;
// import actor.Actor;
import actor.Enemy;
import actor.Slime;
import buttle.*;
import setup.*;

/**
 * ----todoist----
 * in 12/2
 * 
 * アイテムの使用→進化：完了
 * 進化後の得意な手：未完了
 * ルーチンの実装：予定とちょっと違うので可能なら修整する
 * （gitのコメント欄に何が起きてるのか書いておきます）
 * 
 * ----以下は自由目標----
 * エンディング整える（可能なら）
 * レイアウト組み立てなおす
 * 
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
