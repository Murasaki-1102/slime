package app;

import java.util.Scanner;

public class Main {

	public static boolean end = false;
	public static int[][] dungeon = new int[25][3];
	/**
	 * int[][] dungeonはダンジョン情報を表している
	 * 配列の第一要素はダンジョンの広さで25マス
	 * 第二要素はそれぞれのマスごとの情報を保存している
	 * [i][0] = 敵キャラクターの有無(0:なし 1:兵士A 2:兵士B 3:兵士C 4:門番 5:城)
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
				}else{
					dungeon[i][2] = 0;
					dungeon[i+n][2] = 1;
					break;
				}
			}
		}
		displayGame();
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