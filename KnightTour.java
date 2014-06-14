package backtracking;

/**
 * This method is used to demostrate the Knights tour problem using backtracking process
 * @author ankit
 *
 */
public class KnightTour {
	
	
	 int n = 8;
	//Moves of the Knight on the chess Board
	 int xMove[] = {  2, 1, -1, -2, -2, -1,  1,  2 };
	 int yMove[] = {  1, 2,  2,  1, -1, -2, -2, -1 };
	 
	void solveKT(){
		int sol[][] = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				sol[i][j] = -1;
		
		 
		 //Knight is initially at the (0,0) co-ordinate
		 sol[0][0] = 0;
		if( solveKTUtil(0, 0, sol, 1))
			printSol(sol);
		else{
			System.out.println("solution doesn't exist");
		}
	}
	
	void printSol(int[][] sol){
		for(int i =0; i < n; i++){
			for(int j = 0; j < n; j++)
				System.out.print(sol[i][j]+"\t");
			System.out.println();
		}
	}
	
	boolean isSafe(int x, int y){
		return ((x >= 0 && x < n)&&(y >= 0 && y < n)) ? true : false;
	}
	
	boolean solveKTUtil(int x, int y, int[][] sol, int movei){
		
		if(movei == (n * n))
			return true;
		int nextX, nextY;
		for( int k = 0; k < 8; k++){
			nextX  = x + xMove[k];
			nextY  = y + yMove[k];
			if( isSafe(nextX, nextY) && sol[nextX][nextY] == -1 ){
				sol[nextX][nextY] = movei;
				if(solveKTUtil(nextX, nextY, sol, movei+1))
					return true;
				else{
					sol[nextX][nextY] = -1;//backtracking
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		new KnightTour().solveKT();
	}
}
