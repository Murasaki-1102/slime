package buttle;
import java.io.*;
import actor.*;

//戦闘に関する処理＋文
// ムラサキ
public class ButtleContents {

  public static void displayStatus(Slime slime, Enemy enemy) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try {
      System.out.println("[Enterで次へ]");
      reader.readLine();
    } catch (IOException e) {
      System.out.println("問題が発生しました");
    }
    System.out.println("--------------------------------------\n");

    System.out.println("自分：" + slime.getName() + "、体力：" + slime.getHitPoint() + "、攻撃力" + slime.getAttack());
    System.out.println("相手：" + enemy.getName() + "、体力：" + enemy.getHitPoint() + "、攻撃力" + enemy.getAttack());
    System.out.println("グー：1、チョキ：2、パー：3");
    System.out.print("command?:");

  }

  public static void attack(int attack, Enemy enemy, Slime slime) {
    int damage = attack;

    int nokoriHP = enemy.getHitPoint() - damage;
    if (nokoriHP <= 0) {
      enemy.setHitPoint(0);
    } else {
      enemy.setHitPoint(nokoriHP);
    }
    System.out.println("--------------------------------------\n");
    System.out.println(slime.getName() + "の勝ち！！！！");
    System.out.println(enemy.getName() + "は" + damage + "のダメージで残り体力が" + enemy.getHitPoint() + "になった!");
    if (nokoriHP > 0) {
      ButtleContents.displayStatus(slime, enemy);
    }
  }

  public static void enemyAttack(int attack, Slime slime, Enemy enemy) {
    int damage = attack;
    System.out.println("--------------------------------------");
    System.out.println(enemy.getName() + "の勝ち！！！！");

    if (enemy.getMode() == 1 && enemy.getHitPoint() <= 8) {
      System.out.println("勇者は力を振り絞り強力な攻撃を放った！！");
      damage += 4;
    }

    int nokoriHP = slime.getHitPoint() - damage;
    if (nokoriHP <= 0) {
      slime.setHitPoint(0);
    } else {
      slime.setHitPoint(nokoriHP);
    }
    System.out.println(slime.getName() + "は" + damage + "のダメージで残り体力が" + slime.getHitPoint() + "になった!");
    if (nokoriHP > 0) {
      ButtleContents.displayStatus(slime, enemy);
    }
  }

  public static void draw(Slime slime, Enemy enemy) {
    slime.setHitPoint(slime.getHitPoint() - 1);
    enemy.setHitPoint(enemy.getHitPoint() - 1);
    System.out.println("--------------------------------------");
    System.out.println("あいこ！");
    System.out.println(slime.getName() + "はあいこで残り体力が" + slime.getHitPoint() + "になった!");
    System.out.println(enemy.getName() + "はあいこで残り体力が" + enemy.getHitPoint() + "になった!");
    if (slime.getHitPoint() > 0 && enemy.getHitPoint() > 0) {
      ButtleContents.displayStatus(slime, enemy);
    }

  }

  public static void outputResult(boolean enemyDownFlg, Enemy enemy) {
    if (enemyDownFlg) {
      System.out.println("\n勝ちました！");
      // 早津
      switch (enemy.getName()) {
      case "兵士A":
        System.out.println("**********************");
        System.out.println("*グーの書を手に入れた*");
        System.out.println("**********************");
        break;
      case "兵士B":
        System.out.println("************************");
        System.out.println("*チョキの書を手に入れた*");
        System.out.println("************************");
        break;
      case "兵士C":
        System.out.println("**********************");
        System.out.println("*パーの書を手に入れた*");
        System.out.println("**********************");
        break;
      case "門番":
        System.out.println("****************");
        System.out.println("*鍵を手に入れた*");
        System.out.println("****************");
        break;
      }
    } else {
      System.out.println("\n負けました‥");
    }
  }
}