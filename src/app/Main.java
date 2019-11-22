package app;

import app.actor.actor;
import java.util.Scanner;
import java.util.Random;

class Main {

	public static boolean end = false;

	public static void main(String[] args) {
		actor player1;
		player1 = new actor("slime", 12, 3);
		actor player2;
		player2 = new actor("solderA", 12, 4);
		battle(player1, player2);
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
				System.out.println("グー：1、チョキ：2、パー：3");
				System.out.print("command?:");
				Scanner scan = new Scanner(System.in);
				int handA = scan.nextInt();

				switch (handA) {
				case 1:
					System.out.println("お前....グー");
					break;
				case 2:
					System.out.println("お前....チョキ");
					break;
				case 3:
					System.out.println("お前....パー");
					break;
				}
				Random random = new Random();
				int handB = random.nextInt(3);// 0~2
				switch (handB + 1) {
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
				if (handA == (handB + 1)) {
					System.out.println("あいこ");
					a.hitPoint -= 1;
					b.hitPoint -= 1;
				} else if (handA == 1 && (handB + 1) == 2) {// グーとチョキ
					System.out.println("かち");
					b.hitPoint -= a.attack;
				} else if (handA == 1 && (handB + 1) == 3) {// グーとパー
					System.out.println("まけ");
					a.hitPoint -= b.attack;
				} else if (handA == 2 && (handB + 1) == 1) {// チョキとグー
					System.out.println("まけ");
					a.hitPoint -= b.attack;
				} else if (handA == 2 && (handB + 1) == 3) {// チョキとパー
					System.out.println("かち");
					b.hitPoint -= a.attack;
				} else if (handA == 3 && (handB + 1) == 1) {// パーとグー
					System.out.println("かち");
					b.hitPoint -= a.attack;
				} else if (handA == 3 && (handB + 1) == 2) {// パーとチョキ
					System.out.println("まけ");
					a.hitPoint -= b.attack;
				} else {
					System.out.println("正しい手をだして");
					continue;
				}
			}
		}
	}

}