/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.actor.actor;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author C0117253
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		actor slime = new actor("slime", 12, 3);
		actor slimeR = new actor("slimeR", 18, 3);
		actor slimeB = new actor("slimeB", 18, 3);
		actor slimeG = new actor("slimeG", 18, 3);
		actor slimeRB = new actor("slimeRB", 24, 3);
		actor slimeRG = new actor("slimeRG", 24, 3);
		actor slimeBG = new actor("slimeBG", 24, 3);
		actor slimeRGB = new actor("slimeRGB", 32, 8);

		actor soldierA = new actor("soldierA", 12, 4);
		actor soldierB = new actor("soldierB", 12, 4);
		actor soldierC = new actor("soldierC", 12, 4);
		actor guardian = new actor("guardian", 24, 4);
		actor hero = new actor("hero", 35, 8);

		battle(slimeR, guardian);
	}

	public static void battle(actor a, actor b) {
		String hand1 = null;
		String hand2 = null;
		int guardianCount = 0;
		int guardianCountFirst = 0;
		while (true) {
			if (a.hitPoint <= 0) {
				System.out.println("死亡");
				break;
			} else if (b.hitPoint <= 0) {
				System.out.println("バトルに勝利");
				break;
			} else {
				System.out.println("*************************************************");
				System.out.println("お前：" + a.name + "、体力：" + a.hitPoint + "、攻撃力" + a.attack);
				System.out.println("相手：" + b.name + "、体力：" + b.hitPoint + "、攻撃力" + b.attack);
				System.out.println("*************************************************");

				System.out.println("グー：1、チョキ：2、パー：3");
				System.out.print("command?:");
				Scanner scan = new Scanner(System.in);
				int handA = scan.nextInt();

				switch (handA) {
				case 1:
					System.out.println("お前....グー");
					hand1 = "グー";
					break;
				case 2:
					System.out.println("お前....チョキ");
					hand1 = "チョキ";
					break;
				case 3:
					System.out.println("お前....パー");
					hand1 = "パー";
					break;
				}

				Random random = new Random();
				if (b.name == "soldierA") {// グーが75%
					int handB = random.nextInt(100);// 0~99
					if ((handB + 1) >= 25) {
						System.out.println("相手....グー");
						hand2 = "グー";
					} else if ((handB + 1) <= 24 && (handB + 1) >= 13) {
						System.out.println("相手....チョキ");
						hand2 = "チョキ";
					} else {
						System.out.println("相手....パー");
						hand2 = "パー";
					}
				} else if (b.name == "soldierB") {
					int handB = random.nextInt(100);// 0~99
					if ((handB + 1) >= 25) {// チョキが75%
						System.out.println("相手....チョキ");
						hand2 = "チョキ";
					} else if ((handB + 1) <= 24 && (handB + 1) >= 13) {
						System.out.println("相手....グー");
						hand2 = "グー";
					} else {
						System.out.println("相手....パー");
						hand2 = "パー";
					}
				} else if (b.name == "soldierC") {
					int handB = random.nextInt(100);// 0~99
					if ((handB + 1) >= 25) {// パーが75%
						System.out.println("相手....パー");
						hand2 = "パー";
					} else if ((handB + 1) <= 24 && (handB + 1) >= 13) {
						System.out.println("相手....チョキ");
						hand2 = "チョキ";
					} else {
						System.out.println("相手....グー");
						hand2 = "グー";
					}
				} else if (b.name == "guardian") {
					if (guardianCountFirst == 0) {
						hand2 = "グー";
						System.out.println("相手....グー");
						guardianCountFirst++;
					} else if (guardianCount == 3 || guardianCount == 6 || guardianCount == 9 || guardianCount == 12
							|| guardianCount == 15) {// 三回目はランダム
						int handB = random.nextInt(2);// 0~2
						if (handB + 1 == 1) {
							hand2 = "グー";
							System.out.println("相手....グー");
						} else if (handB + 1 == 2) {
							hand2 = "チョキ";
							System.out.println("相手....チョキ");
						} else {
							hand2 = "パー";
							System.out.println("相手....パー");
						}
					} else {
						System.out.println("相手の前の手を出してるよ");
						System.out.println("相手...." + hand2);
					}
					guardianCount++;
					System.out.println(guardianCount);
					if (guardianCount % 3 == 0)
						System.out.println("次は他の手を出してきそうだよ");
				}
				if (hand1.equals(hand2)) {
					System.out.println("あいこ");
					a.hitPoint -= 1;
					b.hitPoint -= 1;
					if (b.name == "guardian") {// 門番の負けカウント
						if (hand1 == "グー") {
							hand2 = "チョキ";
						} else if (hand1 == "チョキ") {
							hand2 = "パー";
						} else {
							hand2 = "グー";
						}
					}
				} else if (hand1 == "グー" && hand2 == "チョキ") {// グーとチョキ
					System.out.println("かち");
					b.hitPoint -= a.attack;
					if (b.name == "guardian") {// 門番の負けカウント
						hand2 = "チョキ";
					}

				} else if (hand1 == "グー" && hand2 == "パー") {// グーとパー
					System.out.println("まけ");
					a.hitPoint -= b.attack;
					if (b.name == "guardian") {
						hand2 = "チョキ";
					}

				} else if (hand1 == "チョキ" && hand2 == "グー") {// チョキとグー
					System.out.println("まけ");
					a.hitPoint -= b.attack;
					if (b.name == "guardian") {
						hand2 = "パー";
					}

				} else if (hand1 == "チョキ" && hand2 == "パー") {// チョキとパー
					System.out.println("かち");
					b.hitPoint -= a.attack;
					if (b.name == "guardian") {// 門番の負けカウント
						hand2 = "パー";
					}
				} else if (hand1 == "パー" && hand2 == "グー") {// パーとグー
					System.out.println("かち");
					b.hitPoint -= a.attack;
					if (b.name == "guardian") {// 門番の負けカウント
						hand2 = "グー";
					}
				} else if (hand1 == "パー" && hand2 == "チョキ") {// パーとチョキ
					System.out.println("まけ");
					a.hitPoint -= b.attack;
					if (b.name == "guardian") {
						hand2 = "グー";
					}

				} else {
					System.out.println("正しい手をだして");
					continue;
				}
			}

		}

	}

}
