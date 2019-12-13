package buttle.routin;

import actor.*;
import java.util.Random;

public class ExtraRoutin extends Routin {
  public static int extraRoutin(Enemy enemy, int beforeMyHand) {
    String name = enemy.getName();
    int beforeHand = beforeMyHand; // 0
    int enemyHand = 0;
    Random random = new Random();
    if (name == "門番") {
      switch (beforeHand) {
      case 1:
        enemyHand = 2;
        break;
      case 2:
        enemyHand = 3;
        break;
      case 3:
        enemyHand = 1;
        break;
      default:
        enemyHand = 1;
        break;
      }
    } else if (name == "勇者") {
      if (enemy.getHitPoint() > 18) {
        switch (beforeHand) {
        case 1:
          enemyHand = 3;
          break;
        case 2:
          enemyHand = 1;
          break;
        case 3:
          enemyHand = 2;
          break;
        default:
          enemyHand = random.nextInt(3) + 1;
          break;
        }
      } else {
        switch (beforeHand) {
        case 1:
          enemyHand = 2;
          break;
        case 2:
          enemyHand = 1;
          break;
        case 3:
          enemyHand = 1;
          break;
        default:
          enemyHand = random.nextInt(3) + 1;
          break;
        }
      }
    }
    return enemyHand;
  }
}