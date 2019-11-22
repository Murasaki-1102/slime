package app;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static boolean end = false;
	public static boolean key = false; //鍵の有無,門番を倒した時にtrueに変える
	public static int[][] dungeon = new int[25][3];
	public static String[] hint = new String[25];
	public static int walk = 300; //歩数カウント,上限歩数にする
	public static int[] items = {0,0,0}; //いったん保留,デバッグ用 グーの書、チョキの書、パーの書の所持状況を管理
	/**
	 * int[][] dungeonはダンジョン情報を表している
	 * 配列の第一要素はダンジョンの広さで25マス
	 * 第二要素はそれぞれのマスごとの情報を保存している
	 * [i][0] = 敵キャラクターの有無(中に 0:なし 1:兵士A 2:兵士B 3:兵士C 4:門番 5:城 を入れる)
	 * [i][1] = スライムが部屋を訪問したことがあるか
	 * [i][2] = スライムが部屋にいるか
	 * 詳細はsetDungeon()関数を読むべし
	 */

	public static void main(String[] args) {
		
		setDungeon();
		showRule();
		displayGame();
		
	}

	private static void setDungeon(){
		// 設計：中田,竹野
		for(int i=0;i<dungeon.length;i++){
			/*
				i = 部屋id
				以下、i部屋目のi番地データを編集する動作
			*/

			/*
				dungeon[i][0] = 敵キャラクターの有無
				0:なし 1:兵士A 2:兵士B 3:兵士C 4:門番 5:城 
				if(i = 敵キャラクターを置きたい部屋番号)
			*/
			if(i == 12){
				//兵士Aを配置
				dungeon[i][0] = 1; 
			}else if(i == 20){
				//兵士Bを配置
				dungeon[i][0] = 2;
			}else if(i == 4){
				//兵士Cを配置
				dungeon[i][0] = 3;
			}else if(i == 19){
				//門番を配置
				dungeon[i][0] = 4;
			}else if(i == 24){
				//城(勇者)を配置
				dungeon[i][0] = 5;
			}else{
				dungeon[i][0] = 0;
			}
			
			/*
				dungeon[i][1] = スライムが部屋を訪問したことがあるか
			*/
			dungeon[i][1] = 0;

			/*
				dungeon[i][2] = スライムが部屋にいるか
			*/
			dungeon[i][2] = 0;
		}
		/**
		 * スライムの初期位置をセット
		 */
		dungeon[0][2] = 1;

		/**
		 * ヒントの内容をセット
		 */
		for(int hintno = 0; hintno < hint.length; hintno++){
			switch(hintno){
				case 0:
					hint[0] = "ここは村の入り口,ここから冒険が始まった";
					break;
				case 1:
					hint[1] = "進化はアイテムを1つだけ使うより,まとめて使ったほうが強くなるらしい";
					break;
				case 2:
					hint[2] = "兵士の出す手を読むことが勝利の鍵だ";
					break;
				case 3:
					hint[3] = "兵士Cはパーを多く出してくる";
					break;
				case 4:
					hint[4] = "兵士Bがいた場所だ";
					break;
				case 5:
					hint[5] = "進化をするタイミングが攻略のカギになる";
					break;
				case 6:
					hint[6] = "兵士のステータスはみんな一緒らしい";
					break;
				case 7:
					hint[7] = "兵士Aはグーを多く出してくる";
					break;
				case 8:
					hint[8] = "勇者はピンチの時とても強くなる";
					break;
				case 9:
					hint[9] = "勇者の攻撃力は8ある";
					break;
				case 10:
					hint[10] = "勇者の行動は門番に似ている";
					break;
				case 11:
					hint[11] = "兵士はそれぞれ得意の手を持っている";
					break;
				case 12:
					hint[12] = "兵士Aがいた場所だ";
					break;
				case 13:
					hint[13] = "門番と勇者を倒すには法則を見破る必要がある";
					break;
				case 14:
					hint[14] = "門番のHPは24ある";
					break;
				case 15:
					hint[15] = "兵士Bは3手同じ手を出すと次の2手は変えてくる";
					break;
				case 16:
					hint[16] = "進化アイテムを3つ同時に使うとめちゃくちゃ強くなるぞ";
					break;
				case 17:
					hint[17] = "門番は最初にグーを出してくる";
					break;
				case 18:
					hint[18] = "勇者のHPは35ある";
					break;
				case 19:
					hint[19] = "ここには門番がいた";
					break;
				case 20:
					hint[20] = "ここには兵士Cがいた";
					break;
				case 21:
					hint[21] = "兵士Bはチョキを多く出してくるらしい";
					break;
				case 22:
					hint[22] = "勇者は体力が減ると行動が変わる";
					break;
				case 23:
					hint[23] = "勇者の攻撃は2回で普通のスライムを沈めるほどのパワーだ";
					break;
				case 24:
					hint[24] = "ここには憎き勇者のいる城があった";
					break;
				default:
					break;
			}
		}
	}

	private static void showRule(){
		/**
		 * 設計：竹野
		 * ルールの表示に関わる関数
		 * reader.readLine()はキー入力を待つ処理
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
			System.out.println("最後に、時間制限について説明します。\nスライムはこの城下町ではお尋ね者です。できるだけ早く城に入り、勇者を倒す必要があります。\nそのため、マスを移動できるのは"+walk+"回が限度です。\n"+walk+"歩以内に兵士や門番を倒し、最後に城マスで勇者を倒せばゲームクリアです！");
			reader.readLine();
			System.out.println("それではゲームを開始しましょう。Enterキーを押してね！");
			reader.readLine();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		} 
		catch (IOException e) {
			System.out.println("問題が発生したよ！");
		}
	}

	private static void displayGame(){
		/**
		 * 設計：中田,大木
		 * マップのコマンド入力
		 */
		System.out.println("残り歩数："+ walk +"歩");
		System.out.println("---Map---");
		displayDungeon();

		System.out.println("【移動】");
		System.out.println("上：w 下：s 右：d 左：a");
		System.out.println("【コマンド】");
		System.out.println("アイテムを使う：u");
		System.out.print("command?：");
		Scanner scan = new Scanner(System.in);
		String str = scan.next();

		int n = 0;
		if(str.equals("w")){
			n = -5;
			moveSlime(n);
		}else if(str.equals("a")){
			n = -1;
			moveSlime(n);
		}else if(str.equals("s")){
			n = 5;
			moveSlime(n);
		}else if(str.equals("d")){
			n = 1;
			moveSlime(n);
		}else if(str.equals("u")){
			useItem();
		}else{
			System.out.println("無効なコマンドです");
			displayGame();
		}
	}
	
	private static void useItem(){
		System.out.println("--------");
		System.out.print("今所持中のアイテム:");
		for(int i = 0;i < items.length;i++){
			if(items[i] == 1){
				switch(i){
					case 0:
						System.out.print("[a]グーの書  ");
						break;
					case 1:
						System.out.print("[b]チョキの書  ");
						break;
					case 2:
						System.out.print("[c]パーの書");
						break;
					default:
						break;
				}
			}
		}
		System.out.println("\n[アイテムを使用する場合、使いたいアイテムの[id]をすべて入力]");
		System.out.println("[アイテムを使用しない場合、qを入力]");
		System.out.print("command?:");
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		System.out.println("--------");
		if(items[0] == 1 && str.equals("a")){
			System.out.println("スライムが進化し、さらにグーの奥義を取得した！");
			System.out.println("進化により体力が全回復！");
			items[0] = 0;
		}else if(items[1] == 1 && str.equals("b")){
			System.out.println("スライムが進化し、さらにチョキの奥義を取得した！");
			System.out.println("進化により体力が全回復！");
			items[1] = 0;
		}else if(items[2] == 1 && str.equals("c")){
			System.out.println("スライムが進化し、さらにパーの奥義を取得した！");
			System.out.println("進化により体力が全回復！");
			items[2] = 0;
		}else if(items[0] == 1 && items[1] == 1 && str.equals("ab") || str.equals("ba")){
			System.out.println("スライムが進化し、さらにグーとチョキの奥義を取得した！");
			System.out.println("進化により体力が全回復！");
			items[0] = 0;
			items[1] = 0;
		}else if(items[0] == 1 && items[2] == 1 && str.equals("ac") || str.equals("ca")){
			System.out.println("スライムが進化し、さらにグーとパーの奥義を取得した！");
			System.out.println("進化により体力が全回復！");
			items[0] = 0;
			items[2] = 0;
		}else if(items[1] == 1 && items[2] == 1 && str.equals("bc") || str.equals("cb")){
			System.out.println("スライムが進化し、さらにチョキとパーの奥義を取得した！");
			System.out.println("進化により体力が全回復！");
			items[1] = 0;
			items[2] = 0;
		}else if(items[0] == 1 && items[1] == 1 && items[2] == 1 && str.equals("abc") || str.equals("acb") || str.equals("bac") || str.equals("bca") || str.equals("cab") || str.equals("cba")){
			System.out.println("スライムが進化し、すべてのステータスが上昇した！");
			System.out.println("進化により体力が全回復！");
			items[0] = 0;
			items[1] = 0;
			items[2] = 0;
		}else if(str.equals("q")){
			displayGame();
		}else{
			System.out.println("無効なコマンドです");
			useItem();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("--------");
			
			System.out.println("[Enterキーでマップに戻る]");
			reader.readLine();
			displayGame();
		}catch(IOException e) {
			System.out.println("問題が発生しました");
		}

	}

	private static void moveSlime(int n){
		int grid = 0;
		/**
		 * スライムの移動に関する関数
		 * 設計：中田
		 */
		for(int i=0;i<dungeon.length;i++){
			if(dungeon[i][2] == 1){
				/**
				 * 端にいる時,移動を制限
				 */
				if(i%5 == 0 && n == -1 ||
				   i <= 4 && n == -5 ||
				   i%5 == 4 && n == 1 ||
				   i >= 20 && n == 5){
					System.out.println("その方向には移動できません");
					break;
				}else if(i+n == 24 && key == false){
					System.out.println("鍵が無ければ城には入れません");
				}else{
					dungeon[i][2] = 0;
					dungeon[i+n][2] = 1;
					dungeon[i+n][1] = 1;
					grid = i+n;
					walk -= 1;
					System.out.print("【ヒント】");
					displayHint(grid);
					break;
				}
			}
		}
		
		displayGame();
	}

	private static void displayHint(int hintno){
		//設計：竹野
		String itis = hint[hintno];
		System.out.println(itis);
	}

	private static void displayDungeon(){
		/**
		 * ダンジョン状況の表示
		 */
		for(int i=0;i<dungeon.length;i++){
			System.out.print("[");
			/**
			 *  敵を配置
			 */
			if(dungeon[i][0] == 1){
				System.out.print(" 兵 ");
			}else if(dungeon[i][0] == 2){
				System.out.print(" 兵 ");
			}else if(dungeon[i][0] == 3){
				System.out.print(" 兵 ");
			}else if(dungeon[i][0] == 4){
				System.out.print(" 門 ");
			}else if(dungeon[i][0] == 5){
				System.out.print(" 城 ");

			/**
			 * スライムを配置
			 */
			}else if(dungeon[i][2] == 1){
				System.out.print(" ス ");

			/**
			 * それ以外
			 */
			}else{
				System.out.print(" 　 ");

			}
			System.out.print("] ");

			
			if(i == 4){
				System.out.print("     | 兵：兵士マス（入ると戦闘開始）");
				System.out.print("\n");
			}else if(i == 9){
				System.out.print("     | 門：門番マス（入ると戦闘開始）");
				System.out.print("\n");
			}else if(i == 14){
				System.out.print("     | 城：城マス");
				System.out.print("\n");
			}else if(i == 19){
				System.out.print("     |   　門番から得られる鍵がないと入れない");
				System.out.print("\n");
			}else if(i == 24){
				System.out.print("     |     （入ると戦闘開始）");
				System.out.print("\n");
			}
		}
	}
}