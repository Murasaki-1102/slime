package setup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ShowRule {
  // 村崎
  public static String slimeBorn() {
    System.out.println("やあ！");
    System.out.println("あなたの名前を教えてください！(半角英数字)");
    Scanner scanner = new Scanner(System.in);
    String name = scanner.next();
    System.out.println("---------------------");
    System.out.println("---------------------");
    System.out.println("---------------------");
    System.out.println("---------------------");
    System.out.println(name + "だね！教えてくれてありがとう！");
    return name;
  }

  public static void showRule() {
    /**
     * 設計：竹野 ルールの表示に関わる関数 reader.readLine()はキー入力を待つ処理
     */
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try {

      System.out.println("(Enterキーで文字送り)");
      System.out.println("「スライム・アタック」の世界へようこそ！");
      reader.readLine();
      System.out.println("このゲームはあなたがスライムとなり,\n仲間を奪った憎き勇者を倒すために城に向かうゲームです。");
      reader.readLine();
      System.out.println("スライムは上下左右に1マス移動することができ、\n兵士や門番、城マスに触れると敵と戦闘になります。");
      reader.readLine();
      System.out.println("勇者のいる城に侵入するには門番を倒して鍵を入手する必要があります。");
      reader.readLine();
      System.out.println("門番や勇者はとても強力です。そこでスライムに与えられたのが、「進化」の力です。");
      reader.readLine();
      System.out.println("フィールドにいる兵士を倒すことである「アイテム」を入手することができます。");
      reader.readLine();
      System.out.println("そのアイテムを使うとなんと体力が全回復し、さらに攻撃力が上がることもあります。");
      reader.readLine();
      System.out.println("アイテムは戦闘中でなければいつでも使用可能で、\n2つ以上を同時に使うこともできます。いつ使うかは戦略が試されるでしょう。");
      reader.readLine();
      System.out.println("戦闘はじゃんけん形式で行います。\nお互いに同時に手を出して、じゃんけんに勝つと攻撃力ぶんのダメージ、\nあいこならお互いに1点のダメージを与えます。");
      reader.readLine();
      System.out.println("また、空白のマスにはヒントが隠されています。\nこのヒントを手に入れることで戦闘に有利な情報が手に入るかもしれません。");
      reader.readLine();
      System.out.println("最後に、時間制限について説明します。\nスライムはこの城下町ではお尋ね者です。できるだけ早く城に入り、勇者を倒す必要があります。\nそのため、マスを移動できるのは20回が限度です。\n"
          + "20歩以内に兵士や門番を倒し、最後に城マスで勇者を倒せばゲームクリアです！");
      reader.readLine();
      System.out.println("それではゲームを開始しましょう。Enterキーを押してね！");
      reader.readLine();
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    } catch (IOException e) {
      System.out.println("問題が発生したよ！");
    }
  }
}