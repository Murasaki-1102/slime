package buttle.routin;

import java.util.Random;

public class EnemyRoutin extends Routin {
  public static int enemyRoutin(String name) {
    Random random = new Random();
    int hand = 0;
    int checker = random.nextInt(100) + 1;
    if (name == "兵士A") {
      if (checker >= 35) {
        hand = 0;
      } else if (checker <= 34 && checker >= 13) {
        hand = 1;
      } else {
        hand = 2;
      }

      // 兵士B
    } else if (name == "兵士B") {
      checker = random.nextInt(100);
      if (checker >= 35) {
        hand = 1;
      } else if (checker <= 34 && checker >= 13) {
        hand = 2;
      } else {
        hand = 0;
      }

      // 兵士C
    } else if (name == "兵士C") {
      checker = random.nextInt(100);
      if (checker >= 35) {
        hand = 2;
      } else if (checker <= 34 && checker >= 13) {
        hand = 1;
      } else {
        hand = 0;
      }
    }

    return hand;
  }
}