package backtracking;

import java.util.Arrays;

public class SubsetSum {

	
	void printSubSet(int s[], int size){
		for(int i = 0; i < size; i++)
			System.out.print(s[i] + "\t");
		System.out.println();
	}
	
	void subsetSum(int s[], int t[], int setSize, int tupletSize, int sum, int ite, int targetSum){
		
		if( targetSum == sum){
			printSubSet(t,tupletSize);
			//Exclude previously added element and consider next element
			subsetSum(s, t, setSize, tupletSize-1, sum-s[ite], ite+1, targetSum);
			return;
		}else{
			for(int i = ite; i < setSize; i++){
				t[tupletSize] = s[i];
				subsetSum(s, t, setSize, tupletSize + 1, sum + s[i], i + 1, targetSum);
			}
		}
		
	}
	
	
	/**
	 * Wrapper that prints subsets to the targetSum
	 * @param sol
	 * @param size
	 * @param targetSum
	 */
	void generateSubSets(int[] sol, int size, int targetSum){
		
		int total = 0;
		Arrays.sort(sol);
		for( int i = 0; i < size; i++)
			total += sol[i];
		//Creating Tuplet Vector
		int t[] = new int[sol.length];
		if(sol[0] <= targetSum && total >= targetSum){
			subsetSum(sol, t, size, 0, 0, 0, targetSum);
		}
	}
	
	
	
	public static void main(String[] args) {
		
		int weights[] = {15, 22, 14, 26, 32, 9, 16, 8};
	    int target = 53;
	    new SubsetSum().generateSubSets(weights, weights.length, target);
	}
}
