package buttle;

import actor.*;
import buttle.routin.*;

import java.util.Scanner;

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
      int enemyHand = EnemyRoutin.enemyRoutin(enemy.getName()) + 1;

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
  public static int exJanken(Slime slime, Enemy enemy, int beforeHand) {
    int beforeMyHand = beforeHand; // 0
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
      int enemyHand = ExtraRoutin.extraRoutin(enemy, beforeMyHand);

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
        beforeMyHand = myHand;
      } else if (myHand == 1 && enemyHand == 2) {// グーとチョキ
        ButtleContents.attack(slime.getAttack(), enemy, slime);
        beforeMyHand = 1;
      } else if (myHand == 1 && enemyHand == 3) {// グーとパー
        ButtleContents.enemyAttack(enemy.getAttack(), slime, enemy);
        beforeMyHand = 1;
      } else if (myHand == 2 && enemyHand == 1) {// チョキとグー
        ButtleContents.enemyAttack(enemy.getAttack(), slime, enemy);
        beforeMyHand = 2;
      } else if (myHand == 2 && enemyHand == 3) {// チョキとパー
        ButtleContents.attack(slime.getAttack(), enemy, slime);
        beforeMyHand = 2;
      } else if (myHand == 3 && enemyHand == 1) {// パーとグー
        ButtleContents.attack(slime.getAttack(), enemy, slime);
        beforeMyHand = 3;
      } else if (myHand == 3 && enemyHand == 2) {// パーとチョキ
        ButtleContents.enemyAttack(enemy.getAttack(), slime, enemy);
        beforeMyHand = 3;
      } else {
        System.out.print("正しい手をだしてね！：");
        continue;
      }
    }

    return beforeMyHand;
  }
}