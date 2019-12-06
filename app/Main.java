package app;
// import java.util.Scanner;
// import actor.Actor;
import actor.Enemy;
import actor.Slime;
import buttle.*;
import setup.*;

/**
 * ----todoist----
 * 
 * in 12/4
 * 
 * アイテムの使用→進化：完了
 * 進化後の得意な手：たぶん完了（しっかりデバッグしたわけじゃないからバグ残ってるかも）
 * ルーチンの実装：未完了（特に門番）
 * n回行動したらランダムに戻る、がうまく実装できない 原因不明
 * 
 * ----以下は自由目標----
 * エンディング整える（可能なら）
 * レイアウト組み立てなおす
 * 
 */

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
