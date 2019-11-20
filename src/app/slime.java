package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class slime {

public static void main(String[] args) {
// １行ずつ読めるように BufferedReader クラスを使う。
BufferedReader reader = new BufferedReader(new InputStreamReader(
System.in));
try {
System.out.println("「スライム・アタック」の世界へようこそ！\n\n\n\n\n");

// エンターキーを待つだけ。
reader.readLine();

System.out.println("このゲームはあなたがスライムとなり,\n仲間を奪った憎き勇者を倒すために城に向かうゲームです。\n\n\n\n\n");

// エンターキーを待つだけ。
reader.readLine();

System.out.println("スライムは上下左右に1マス移動することができ、\n兵士や門番、城マスに触れると敵と戦闘になります。\n\n\n\n\n");

// エンターキーを待つだけ。
reader.readLine();

System.out.println("城に侵入するには門番を倒して鍵を入手する必要があります。\n\n\n\n\n");

reader.readLine();

System.out.println("門番や勇者を倒すためにスライムに与えられたのが、「進化」の力です。\n\n\n\n\n");

reader.readLine();

System.out.println("フィールドにいる兵士を倒すことである「アイテム」を入手することができます。\n\n\n\n\n");

reader.readLine();

System.out.println("そのアイテムを使うとなんと体力が全回復し、さらに攻撃力が上がることもあります。\n\n\n\n\n");

reader.readLine();

System.out.println("アイテムは戦闘中でなければいつでも使用可能で、\n2つ以上を同時に使うこともできます。いつ使うかは戦略が試されるでしょう。\n\n\n\n");

reader.readLine();

System.out.println("戦闘はじゃんけん形式で行います。\nお互いに同時に手を出して、じゃんけんに勝つと攻撃力ぶんのダメージ、\nあいこならお互いに1点のダメージを与えます。\n\n\n");

reader.readLine();

System.out.println("また、空白のマスにはヒントが隠されています。\nこのヒントを手に入れることで戦闘に有利な情報が手に入るかもしれません。\n\n\n\n");

reader.readLine();

System.out.println("最後に、時間制限について説明します。\nスライムはこの城下町ではお尋ね者です。できるだけ早く城に入り、勇者を倒す必要があります。\nそのため、マスを移動できるのは20回が限度です。\n20歩以内に兵士や門番を倒し、最後に城マスで勇者を倒せばゲームクリアです！\n\n");



System.out.println("それではゲームスタート!!");
} catch (IOException e) {
System.out.println("問題が発生したよ！");
}
}
}