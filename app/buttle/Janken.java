package buttle;

import actor.*;
import app.Main;

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
      String name = enemy.getName();
      try{
        myHand = scan.nextInt();
      }catch(Exception e){
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

      if(myHand == 1 || myHand == 2 || myHand == 3){
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
        System.out.print("正しい手をだしてね：");
        continue;
      }
    }
  }

  public static int routin(String name){
    int hand = 0;
    int checker = 0;
    Random random = new Random();
    if(name == "solder1"){
      checker = random.nextInt(100);
      if((checker+1) >= 35){
        hand = 0;
      }else if ((checker+1)<= 34 && (checker+1) >= 13){
        hand = 1;
      }else{
        hand = 2;
      }

    //兵士B
    }else if(name == "solder2"){
      checker = random.nextInt(100);
      if((checker+1) >= 35){
        hand = 1;
      }else if ((checker+1)<= 34 && (checker+1) >= 13){
        hand = 2;
      }else{
        hand = 0;
      }
    
    //兵士C
    }else if(name == "solder3"){
      checker = random.nextInt(100);
      if((checker+1) >= 35){
        hand = 2;
      }else if ((checker+1)<= 34 && (checker+1) >= 13){
        hand = 1;
      }else{
        hand = 0;
      }
    }

    return hand;
  }
}