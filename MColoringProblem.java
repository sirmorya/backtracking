package backtracking;

public class MColoringProblem {

	
	static int V = 4;
	
	boolean  isSafe(int v, int c, int[] color, int[][] graph){
		
		for(int i = 0; i < V; i++)
			if(graph[v][i] == 1 && (color[i] == c))
				return false;
		return true;
	}
	
	
	/**
	 * This method acts as a utility for m-graph coloring mechanism.
	 * @param graph
	 * @param color
	 * @param m
	 * @param v
	 * @return
	 */
	boolean graphcoloringUtil(int graph[][], int color[], int m,  int v){
		
		if( v == V)
			return true;
		for(int i = 1; i <= m; i++){
			if(isSafe(v, i, color, graph)){
				
				color[v] = i;
				if(graphcoloringUtil(graph, color, m, v+1))
					return true;
				
				//If assigning color "i" doesn't lead to a solution then removing it
				color[v] = 0;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[][]graph = {{0, 1, 1, 1},
		        {1, 0, 1, 0},
		        {1, 1, 0, 1},
		        {1, 0, 1, 0}};
		
		int color[] = new int[V];
		//Maximum number of colors used for coloring
		int m = 3;
		new MColoringProblem().graphcoloringUtil(graph, color, m, 0);
		for(int i = 0; i < V; i++)
			System.out.print(color[i]+"\t");
	}
}
