package backtracking;

/**
 * Sudoku Generator
 * 
 * @author ankit
 *
 */
public class Sudoku {

	static int N = 9;
	int UNASSIGNED = 0;
	int unAssignrow, unAssignCol;
	boolean findUnassigned(int set[][]){
		
		for(unAssignrow = 0; unAssignrow < N; unAssignrow++)
			for(unAssignCol = 0; unAssignCol < N; unAssignCol++)
				if(set[unAssignrow][unAssignCol] == UNASSIGNED)
					return true;
		return false;
	}
	
	boolean solveSudoku(int set[][]){
		int row, col;
		if(!findUnassigned(set))
			return true;
		row = unAssignrow;
		col = unAssignCol;
		for(int num = 1; num <= 9; num++){
			
			if(isSafe(set, row, col, num)){
				set[row][col] = num;
				if(solveSudoku(set))
					return true;
				set[row][col] = UNASSIGNED;//backtracking
			}
		}
		return false;
	}
	
	/**
	 * It checks whether the number isn't present in a row, column or in a box
	 * @param set
	 * @param row
	 * @param col
	 * @param num
	 * @return
	 */
	boolean isSafe(int set[][], int row, int col, int num){
		if(!usedInRow(set, col, num) &&
		   !usedInCol(set, row, num) &&
		   !usedInBox(set, row - row%3, col - col%3, num))
			return true;
		return false;
	}
	
	boolean usedInRow(int set[][], int col, int num){
		
		for(int i = 0; i < N; i++)
			if(set[i][col]  == num)
				return true;
		return false;
	}
	
	
	boolean usedInCol(int set[][], int row, int num){
		
		for(int i = 0; i < N; i++)
			if(set[row][i] == num)
				return true;
		return false;
	}
	
	boolean usedInBox(int set[][], int boxStart, int boxCol, int num){
		
		for(int i = 0; i < 3; i++)
			for( int j = 0 ; j < 3; j++)
				if(set[i + boxStart][j + boxCol] == num)
					return true;
		return false;
	}
	
	
	public static void main(String[] args) {
		
		 int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                 {5, 2, 0, 0, 0, 0, 0, 0, 0},
                 {0, 8, 7, 0, 0, 0, 0, 3, 1},
                 {0, 0, 3, 0, 1, 0, 0, 8, 0},
                 {9, 0, 0, 8, 6, 3, 0, 0, 5},
                 {0, 5, 0, 0, 9, 0, 6, 0, 0},
                 {1, 3, 0, 0, 0, 0, 2, 5, 0},
                 {0, 0, 0, 0, 0, 0, 0, 7, 4},
                 {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		 new Sudoku().solveSudoku(grid);
		 for(int i =0; i < N; i++){
				for(int j = 0; j < N; j++)
					System.out.print(grid[i][j]+"\t");
				System.out.println();
			}
		 
	}
}
