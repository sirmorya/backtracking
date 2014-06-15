package backtracking;

public class RatinMaze {
	
	
	static int n = 4;
	int maze[][]  =  { {1, 0, 0, 0},
	        {1, 1, 0, 1},
	        {0, 1, 0, 0},
	        {1, 1, 1, 1}
	    };
	boolean isSafe(int x, int y){
		return ((x >= 0 && x < n) && (y >= 0 && y < n));
	}
	
	boolean ratInMazeUtil(int x, int y, int sol[][]){
		
		if((x == n-1) && (y == n-1))
			return true;
		if(isSafe(x, y) && maze[x][y] == 1){
			sol[x][y] = 1;
			if(ratInMazeUtil(x+1, y, sol))
				return true;
			if(ratInMazeUtil(x, y+1, sol))
				return true;
			//If none of the above moves lead to the destination then back-track
			sol[x][y] = 0;
			return false;
			
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		
		int sol[][] = new int[n][n];
		new RatinMaze().ratInMazeUtil(0, 0, sol);
		for(int i =0; i < n; i++){
			for(int j = 0; j < n; j++)
				System.out.print(sol[i][j]+"\t");
			System.out.println();
		}
	}
}
