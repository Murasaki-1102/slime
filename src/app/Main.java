package app;

import app.actor.actor;
import java.util.Scanner;
import java.util.Random;

class Main {

	public static boolean end = false;

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

		battle(slime, soldierC);
	}

	public static void battle(actor a, actor b) {
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
				String hand1 = null;
				String hand2 = null;

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
				} else {
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
				}
				if (hand1.equals(hand2)) {
					System.out.println("あいこ");
					a.hitPoint -= 1;
					b.hitPoint -= 1;
				} else if (hand1 == "グー" && hand2 == "チョキ") {// グーとチョキ
					System.out.println("かち");
					b.hitPoint -= a.attack;
				} else if (hand1 == "グー" && hand2 == "パー") {// グーとパー
					System.out.println("まけ");
					a.hitPoint -= b.attack;
				} else if (hand1 == "チョキ" && hand2 == "グー") {// チョキとグー
					System.out.println("まけ");
					a.hitPoint -= b.attack;
				} else if (hand1 == "チョキ" && hand2 == "パー") {// チョキとパー
					System.out.println("かち");
					b.hitPoint -= a.attack;
				} else if (hand1 == "パー" && hand2 == "グー") {// パーとグー
					System.out.println("かち");
					b.hitPoint -= a.attack;
				} else if (hand1 == "パー" && hand2 == "チョキ") {// パーとチョキ
					System.out.println("まけ");
					a.hitPoint -= b.attack;
				} else {
					System.out.println("正しい手をだして");
					continue;
				}

				// switch (handB + 1) {
				// case 1:
				// System.out.println("相手....グー");
				// break;
				// case 2:
				// System.out.println("相手....チョキ");
				// break;
				// case 3:
				// System.out.println("相手....パー");
				// break;
				// }
				// if (handA == (handB + 1)) {
				// System.out.println("あいこ");
				// a.hitPoint -= 1;
				// b.hitPoint -= 1;
				// } else if (handA == 1 && (handB + 1) == 2) {//グーとチョキ
				// System.out.println("かち");
				// b.hitPoint -= a.attack;
				// } else if (handA == 1 && (handB + 1) == 3) {//グーとパー
				// System.out.println("まけ");
				// a.hitPoint -= b.attack;
				// } else if (handA == 2 && (handB + 1) == 1) {//チョキとグー
				// System.out.println("まけ");
				// a.hitPoint -= b.attack;
				// } else if (handA == 2 && (handB + 1) == 3) {//チョキとパー
				// System.out.println("かち");
				// b.hitPoint -= a.attack;
				// } else if (handA == 3 && (handB + 1) == 1) {//パーとグー
				// System.out.println("かち");
				// b.hitPoint -= a.attack;
				// } else if (handA == 3 && (handB + 1) == 2) {//パーとチョキ
				// System.out.println("まけ");
				// a.hitPoint -= b.attack;
				// } else {
				// System.out.println("正しい手をだして");
				// continue;
				// }
			}
		}
	}

}