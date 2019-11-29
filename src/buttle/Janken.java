package buttle;

import actor.*;
import java.util.Scanner;
import java.util.Random;
//村崎 たくみ
public class Janken {

  public static void janken(Slime slime, Enemy enemy) {
    while (true) {
      if (slime.getHitPoint() <= 0) {
        System.out.println("死亡");
        break;
      } else if (enemy.getHitPoint() <= 0) {
        System.out.println("バトルに勝利");
        break;
      } else {

        Scanner scan = new Scanner(System.in);
        int myHand = scan.nextInt();

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
        Random random = new Random();
        int enemyHand = random.nextInt(3) + 1;
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
        if (myHand == enemyHand) {
          ButtleContents.draw(slime, enemy);
        } else if (myHand == 1 && enemyHand == 2) {// グーとチョキ
          ButtleContents.attack(slime.getAttack(), enemy, slime);
        } else if (myHand == 1 && enemyHand == 3) {// グーとパー
          ButtleContents.enemyAttack(enemy.getAttack(), slime, enemy);
        } else if (myHand == 2 && enemyHand == 1) {// チョキとグー
          ButtleContents.enemyAttack(enemy.getAttack(), slime, enemy);
        } else if (myHand == 2 && enemyHand == 3) {// チ ョキとパー
          ButtleContents.attack(slime.getAttack(), enemy, slime);
        } else if (myHand == 3 && enemyHand == 1) {// パーとグー
          ButtleContents.attack(slime.getAttack(), enemy, slime);
        } else if (myHand == 3 && enemyHand == 2) {// パーとチョキ
          ButtleContents.enemyAttack(enemy.getAttack(), slime, enemy);
        } else {
          System.out.println("正しい手をだして");
          continue;
        }
      }
    }
  }

}