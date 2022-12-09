public class day8{

	private static int visibleTrees;

	public static void main(String[] args){

		int[][] trees = { {3, 0, 3, 7, 3},
						  {2, 5, 5, 1, 2},
						  {6, 2, 3, 3, 2},
						  {3, 3, 0, 4, 9},
						  {3, 5, 0, 9, 0} };

		int height = trees.length;
		int width = trees[0].length;

		for(int i = 0; i < height; i++){

			for(int j = 0; j < width; j++){

				if(i == 0 || i == height - 1){
					continue;
				}else if(j > 0 && j < width - 1){
					checkRight(trees, i, j);
				}
			}
			//System.out.println();
		}
		checkRight(trees, 1, 1);
	}
	public static void checkDown(int[][] treeMap, int d1, int d2){

		int treeHeight = treeMap[d1][d2];
		System.out.println("Tree height: " + treeHeight);

		for(int i = d1 + 1; i < treeMap.length; i++){

			if(treeMap[i][d2] > treeHeight){
				System.out.println("Next tree height: " + treeMap[i][d2]);
				System.out.println("Error- tree is not visible from bottom!");
				break;
			}else{

				System.out.println("Next tree height: " + treeMap[i][d2]);

				//we are at the bottom
				if(i == treeMap.length - 1){
					visibleTrees++;
					//System.out.println("Tree is visible!");

				}
			}
		}
	}
	public static void checkRight(int[][] treeMap, int d1, int d2){

		int treeHeight = treeMap[d1][d2];
		System.out.println("Tree height: " + treeHeight);

		for(int i = d2 + 1; i < treeMap[0].length; i++){
			
			System.out.println(treeMap[d1][i]);
			
		}
	}
	public static boolean isValid(int row, int col, int[][] treeMap){

		if(row < 0 || row >= treeMap.length || col < 0 || col >= treeMap[0].length){

			return true;
		}
		return false;
	}
}