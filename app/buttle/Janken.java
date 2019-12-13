package buttle;

import actor.*;
//import app.Main;

import java.util.Scanner;
import java.util.Random;
//村崎 たくみ
public class Janken {
  public static int count = 0;
  public static int memory = 0;

  public static void janken(Slime slime, Enemy enemy) {
    while (true) {
      if (slime.getHitPoint() <= 0) {
        System.out.println("死亡");
        break;
      } else if (enemy.getHitPoint() <= 0) {
        System.out.println("バトルに勝利");
        break;
      }
      Scanner scan = new Scanner(System.in);
      int myHand = 0;

      try {
        myHand = scan.nextInt();
      } catch (Exception e) {
        System.out.print("正しい手をだしてね：");
        continue;
      }
      switch (myHand) {
      case 1:
        System.out.println("自分....グー");
        break;
      case 2:
        System.out.println("自分....チョキ");
        break;
      case 3:
        System.out.println("自分....パー");
        break;
      }
      int enemyHand = routin(enemy.getName()) + 1;

      if (myHand == 1 || myHand == 2 || myHand == 3) {
        switch (enemyHand) {
        case 1:
          System.out.println("相手....グー");
          break;
        case 2:
          System.out.println("相手....チョキ");
          break;
        case 3:
          System.out.println("相手....パー");
          break;
        }
      }
      if (myHand == enemyHand) {
        ButtleContents.draw(slime, enemy);
      } else if (myHand == 1 && enemyHand == 2) {// グーとチョキ
        if (slime.getMode() == 1 || slime.getMode() == 12) {
          ButtleContents.attack(slime.getAttack() + 3, enemy, slime);
        } else {
          ButtleContents.attack(slime.getAttack(), enemy, slime);
        }
      } else if (myHand == 1 && enemyHand == 3) {// グーとパー
        ButtleContents.enemyAttack(enemy.getAttack(), slime, enemy);
      } else if (myHand == 2 && enemyHand == 1) {// チョキとグー
        ButtleContents.enemyAttack(enemy.getAttack(), slime, enemy);
      } else if (myHand == 2 && enemyHand == 3) {// チ ョキとパー
        if (slime.getMode() == 2 || slime.getMode() == 12) {
          ButtleContents.attack(slime.getAttack() + 3, enemy, slime);
        } else {
          ButtleContents.attack(slime.getAttack(), enemy, slime);
        }
      } else if (myHand == 3 && enemyHand == 1) {// パーとグー
        if (slime.getMode() == 3 || slime.getMode() == 23) {
          ButtleContents.attack(slime.getAttack() + 3, enemy, slime);
        } else {
          ButtleContents.attack(slime.getAttack(), enemy, slime);
        }
      } else if (myHand == 3 && enemyHand == 2) {// パーとチョキ
        ButtleContents.enemyAttack(enemy.getAttack(), slime, enemy);
      } else {
        System.out.print("正しい手をだしてね：");
        continue;
      }
    }
  }

  // ボス戦（門番、勇者）用に特別に関数を用意する（中身はほぼ一緒）
  public static int exJanken(Slime slime, Enemy enemy, int count, int memd) {
    int memory = memd;
    while (true) {
      if (slime.getHitPoint() <= 0) {
        System.out.println("死亡");
        break;
      } else if (enemy.getHitPoint() <= 0) {
        System.out.println("バトルに勝利");
        break;
      }

      Scanner scan = new Scanner(System.in);
      int myHand = 0;

      try {
        myHand = scan.nextInt();
      } catch (Exception e) {
        System.out.print("正しい手をだしてね！：");
        continue;
      }
      switch (myHand) {
      case 1:
        System.out.println("自分....グー");
        break;
      case 2:
        System.out.println("自分....チョキ");
        break;
      case 3:
        System.out.println("自分....パー");
        break;
      }

      int enemyHand = exRoutin(enemy, count, memory);

      if (myHand == 1 || myHand == 2 || myHand == 3) {
        switch (enemyHand) {
        case 1:
          System.out.println("相手....グー");
          break;
        case 2:
          System.out.println("相手....チョキ");
          break;
        case 3:
          System.out.println("相手....パー");
          break;
        }
      }

      if (myHand == enemyHand) {
        ButtleContents.draw(slime, enemy);
        memory = myHand;
      } else if (myHand == 1 && enemyHand == 2) {// グーとチョキ
        ButtleContents.attack(slime.getAttack(), enemy, slime);
        memory = 1;
      } else if (myHand == 1 && enemyHand == 3) {// グーとパー
        ButtleContents.enemyAttack(enemy.getAttack(), slime, enemy);
        memory = 1;
      } else if (myHand == 2 && enemyHand == 1) {// チョキとグー
        ButtleContents.enemyAttack(enemy.getAttack(), slime, enemy);
        memory = 2;
      } else if (myHand == 2 && enemyHand == 3) {// チョキとパー
        ButtleContents.attack(slime.getAttack(), enemy, slime);
        memory = 2;
      } else if (myHand == 3 && enemyHand == 1) {// パーとグー
        ButtleContents.attack(slime.getAttack(), enemy, slime);
        memory = 3;
      } else if (myHand == 3 && enemyHand == 2) {// パーとチョキ
        ButtleContents.enemyAttack(enemy.getAttack(), slime, enemy);
        memory = 3;
      } else {
        System.out.print("正しい手をだしてね！：");
        continue;
      }
    }

    return memory;
  }

  public static int routin(String name) {
    int hand = 0;
    int checker = 0;
    Random random = new Random();
    if (name == "兵士A") {
      checker = random.nextInt(100);
      if ((checker + 1) >= 35) {
        hand = 0;
      } else if ((checker + 1) <= 34 && (checker + 1) >= 13) {
        hand = 1;
      } else {
        hand = 2;
      }

      // 兵士B
    } else if (name == "兵士B") {
      checker = random.nextInt(100);
      if ((checker + 1) >= 35) {
        hand = 1;
      } else if ((checker + 1) <= 34 && (checker + 1) >= 13) {
        hand = 2;
      } else {
        hand = 0;
      }

      // 兵士C
    } else if (name == "兵士C") {
      checker = random.nextInt(100);
      if ((checker + 1) >= 35) {
        hand = 2;
      } else if ((checker + 1) <= 34 && (checker + 1) >= 13) {
        hand = 1;
      } else {
        hand = 0;
      }
    }

    return hand;
  }

  public static int exRoutin(Enemy enemy, int count, int memdef) {
    String name = enemy.getName();
    int memory = memdef;
    int hand = 0;
    // System.out.println("mem:"+memory+",cou:"+count);

    Random random = new Random();
    if (name == "門番") {
      switch (memory) {
      case 1:
        hand = 1;
        break;
      case 2:
        hand = 2;
        break;
      case 3:
        hand = 0;
        break;
      default:
        hand = 0;
        break;
      }
    } else if (name == "勇者") {
      if (enemy.getHitPoint() > 18) {
        switch (memory) {
        case 1:
          hand = 2;
          break;
        case 2:
          hand = 0;
          break;
        case 3:
          hand = 1;
          break;
        default:
          hand = random.nextInt(3);
          break;
        }
      } else {
        switch (memory) {
        case 1:
          hand = 1;
          break;
        case 2:
          hand = 2;
          break;
        case 3:
          hand = 0;
          break;
        default:
          hand = random.nextInt(3);
          break;
        }
      }
    }
    return hand + 1;
  }
}