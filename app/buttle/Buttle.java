package buttle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import actor.*;
//村崎
public class Buttle {
  public static boolean doButtle(Slime slime, Enemy enemy){
    boolean enemyDownFlg = false;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("戦闘スタート！");
    do {

      String str = null;

      //str = br.readLine();
      // Janken.janken(slime,enemy);
      // System.out.println("こちらの攻撃！");
      ButtleContents.displayStatus(slime, enemy);
      Janken.janken(slime, enemy);
      ButtleContents.attack(slime.getAttack(), enemy, slime);

      if (enemy.getHitPoint() == 0) {
        enemyDownFlg = true;
        break;
      }

      // System.out.println("相手の攻撃！");
      ButtleContents.enemyAttack(enemy.getAttack(), slime, enemy);

    } while (slime.getHitPoint() != 0);

    ButtleContents.outputResult(enemyDownFlg);
    System.out.println("バトルが終了しました");
    
    return enemyDownFlg;
  }
}
