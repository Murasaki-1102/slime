package buttle.routin;

import java.util.Random;

public class Routin {
  Random random = new Random();
  int hand = 0;
  int checker = random.nextInt(100) + 1; // 1から100までの乱数
}