package app;

class Main {

	public static boolean end = false;
	public static int[][] dungeon = new int[25][2];

	public static void main(String[] args) {
		
		setDungion();
		
		setSlime();

		setEnemy();

		setBasttleStatus();

		displayGame();
		

	}

	private static setDungeon(){
		// 設計：中田
		for(int i=0;i<dungeon.length;i++){
			/*
				dungeon[i] = 部屋id
			*/
			dungeon[i] = i;

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

			return 0;
		}
	}
}