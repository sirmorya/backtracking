package backtracking;

/**
 * 
 * The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
 * 
 * @author ankit
 *
 */
public class NQueenProblem {
	
	static int n = 5;
	
	/**
	 * This method is used to check whether the queen can be placed in the position sol[row][col]
	 * @param row
	 * @param col
	 * @param sol
	 * @return
	 */
	boolean isSafe(int row, int col, int sol[][]){
		int i, j;
		for( i = 0 ; i < col; i ++)
			if(sol[row][i] == 1)
				return false;
		for( i = row, j = col; i >=0 && j >=0; i--, j--)
			if(sol[i][j] == 1)
				return false;
		for( i = row, j = col; i < n && j >=0; i++, j--)
			if(sol[i][j] == 1)
				return false;
		return true;		
	}
	
	boolean solveNQUtil(int col, int sol[][]){
		//base case if all the queen has been placed
		if(col == n)
			return true;
		//Placing the Queen in all the rows of the column
		for(int i = 0; i < n; i++){
			//Checking if it's safe to place the Queen at (i,col) co-ordinate
			if(isSafe(i, col, sol)){
				sol[i][col] = 1;
				if (solveNQUtil(col+1, sol)) return true;
				//If placing the Queen at sol[i][col] doesn't lead to the solution then back-track
				sol[i][col] = 0;
				
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		int sol[][] = new int[n][n];
		new NQueenProblem().solveNQUtil(0, sol);
		for(int i =0; i < n; i++){
			for(int j = 0; j < n; j++)
				System.out.print(sol[i][j]+"\t");
			System.out.println();
		}
	}
}
