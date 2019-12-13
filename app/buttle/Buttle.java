package buttle;

import actor.*;

//村崎
public class Buttle {

  public static boolean doButtle(Slime slime, Enemy enemy) {

    int beforeMyHand = 0;
    boolean enemyDownFlg = false;
    System.out.println("\n\n\n\n--------！--------\n\n\n\n");
    System.out.println("-----------------");
    System.out.println(enemy.getName() + "と出会った！");
    System.out.println("戦闘スタート！");
    do {
      ButtleContents.displayStatus(slime, enemy);
      if (enemy.getName() != "門番" && enemy.getName() != "勇者") {
        Janken.janken(slime, enemy);
      } else {
        beforeMyHand = Janken.exJanken(slime, enemy, beforeMyHand);
      }
      if (enemy.getHitPoint() == 0) {
        enemyDownFlg = true;
        break;
      }
    } while (slime.getHitPoint() != 0);

    ButtleContents.outputResult(enemyDownFlg);
    System.out.println("バトルが終了しました");

    return enemyDownFlg;
  }
}
