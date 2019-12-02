package buttle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import actor.*;
//村崎
public class Buttle {
  public static boolean doButtle(Slime slime, Enemy enemy){
    boolean enemyDownFlg = false;
    int count = 0;
    int memory = 0;
    System.out.println("-----------------");
    System.out.println(enemy.getName() + "と出会った！");
    System.out.println("戦闘スタート！");
    do {
      ButtleContents.displayStatus(slime, enemy);
      if(enemy.getName() != "gate" || enemy.getName() != "hero"){
        Janken.janken(slime, enemy);
      }else{
        memory = Janken.exJanken(slime,enemy,count,memory);
        count++;
        if(count > 3){
          count = 0;
        }
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
