//package app;
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
 * ルーチンの実装：予定とちょっと違う
 * ランダム→相手の手依存→相手の手依存→相手の手依存→ランダム→…って感じで、
 * 「4手ごとにランダムで出す手を抽選し直す」になってる
 * 若干難易度上がってると思う
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
