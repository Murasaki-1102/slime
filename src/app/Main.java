package app;

public class Main {

	public static boolean end = false;
	public static int[][] dungeon = new int[25][3];

	public static void main(String[] args) {
		
		setDungeon();

		displayGame();
		
	}

	private static void setDungeon(){
		// 設計：中田
		for(int i=0;i<dungeon.length;i++){
			/*
				dungeon[i] = 部屋id
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
				dungeon[i][1] = スライムが部屋にいるか
			*/
			dungeon[i][2] = 0;
		}
	}

	private static void displayGame(){
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
				System.out.print("　▲　");

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
			if(i == 4 || i == 8 || i == 16 || i == 24){
				System.out.print("\n");
			}
		}
	}
}