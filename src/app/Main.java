package app;

import java.util.Scanner;

public class Main {

	public static boolean end = false;
	public static boolean key = false; //鍵の有無,門番を倒した時にtrueに変える
	public static int[][] dungeon = new int[25][3];
	public static String[] hint = new String[25];
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
		displayGame();
		
	}

	private static void setDungeon(){
		// 設計：中田
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
			}else if(i == 4){
				//兵士Bを配置
				dungeon[i][0] = 2;
			}else if(i == 20){
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

	private static void displayGame(){
		/**
		 * マップのコマンド入力
		 */
		System.out.println("-------");
		displayDungeon();

		System.out.println("【移動】");
		System.out.println("上：w 下：s 右：d 左：a");
		System.out.print("command?：");
		Scanner scan = new Scanner(System.in);
		String str = scan.next();

		int n = 0;
		if(str.equals("w")){
			n = -5;
		}if(str.equals("a")){
			n = -1;
		}if(str.equals("s")){
			n = 5;
		}if(str.equals("d")){
			n = 1;
		}
		moveSlime(n);
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
					grid = i+n;
					break;
				}
			}
		}
		displayHint(grid);
		displayGame();
	}

	private static void displayHint(int hintno){
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

			/**
			 * 正しい実装方法がわからんので力技で配置
			 * あとで綺麗にする
			 */
			if(i == 4 || i == 9 || i == 14 || i == 19 || i == 24){
				System.out.print("\n");
			}
		}
	}
}