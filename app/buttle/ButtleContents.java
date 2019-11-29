package buttle;

import actor.*;

//戦闘に関する処理＋文
// ムラサキ
public class ButtleContents {

  public static void displayStatus(Slime slime, Enemy enemy) {
    System.out.println("--------------------------------------");

    System.out.println("自分：" + slime.getName() + "、体力：" + slime.getHitPoint() + "、攻撃力" + slime.getAttack());
    System.out.println("相手：" + enemy.getName() + "、体力：" + enemy.getHitPoint() + "、攻撃力" + enemy.getAttack());
    System.out.println("グー：1、チョキ：2、パー：3");
    System.out.println("command?:");

  }

  public static void attack(int attack, Enemy enemy, Slime slime) {
    int damage = attack;

    int nokoriHP = enemy.getHitPoint() - damage;
    if (nokoriHP <= 0) {
      enemy.setHitPoint(0);
    } else {
      enemy.setHitPoint(nokoriHP);
    }
    System.out.println("--------------------------------------");
    System.out.println(slime.getName() + "の勝ち！！！！");
    System.out.println(enemy.getName() + "は" + damage + "のダメージで残り体力が" + enemy.getHitPoint() + "になった!");
  }

  public static void enemyAttack(int attack, Slime slime, Enemy enemy) {
    int damage = attack;

    int nokoriHP = slime.getHitPoint() - damage;
    if (nokoriHP <= 0) {
      slime.setHitPoint(0);
    } else {
      slime.setHitPoint(nokoriHP);
    }
    System.out.println("--------------------------------------");
    System.out.println(enemy.getName() + "の勝ち！！！！");
    System.out.println(slime.getName() + "は" + damage + "のダメージで残り体力が" + slime.getHitPoint() + "になった!");
  }

  public static void draw(Slime slime, Enemy enemy) {
    slime.setHitPoint(slime.getHitPoint() - 1);
    enemy.setHitPoint(enemy.getHitPoint() - 1);
    System.out.println("--------------------------------------");
    System.out.println("あいこ！");
    System.out.println(slime.getName() + "はあいこで残り体力が" + slime.getHitPoint() + "になった!");
    System.out.println(enemy.getName() + "はあいこで残り体力が" + enemy.getHitPoint() + "になった!");
  }

  public static void outputResult(boolean enemyDownFlg) {
    if (enemyDownFlg) {
      System.out.println("\n勝ちました！");
    } else {
      System.out.println("\n負けました‥");
    }
  }
}