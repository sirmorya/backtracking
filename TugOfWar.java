package backtracking;

public class TugOfWar {
	 
	int minDiff = Integer.MAX_VALUE;
	
	void TOWUtil(int[] a, int n, boolean[] currElements, int noOfElements, boolean[] sol, int sum, int currSum, int currPos){
		
		if(currPos == n)
			return;
		//Checks whether the number of elements left are not less than the number of elements required for the solution
		if((n/2 - noOfElements) > (n - currPos))
			return;
		
		// considers the case when teh current element isn't included in the solution
		TOWUtil(a, n, currElements, noOfElements, sol, sum, currSum, currPos+1);
		
		//Add current element to the solution
		noOfElements ++;
		currSum += a[currPos];
		currElements[currPos] = true;
		
		//Checks if a solution is formed
		if( noOfElements == n/2){
			if(Math.abs(sum/2 - currSum) < minDiff){
				minDiff = Math.abs(sum/2 - currSum);
				for(int i =0; i <  n; i++)
					sol[i] = currElements[i];
			}
		}else{
			//Include the current element
			TOWUtil(a, n, currElements, noOfElements, sol, sum, currSum, currPos+1);
		}
		currElements[currPos] = false;
	}
   	
	void tugOfwar(int[] a, int n){
		
		//The boolean array which contains the information about the inclusion and exclusion of elements in the set.
		boolean currElements[] = new boolean[n];
		
		//Inclusion/Exclusion array for final solution
		boolean sol[] = new boolean[n];
		
		int sum = 0;
		
		for(int i = 0; i < n; i++){
			sum += a[i];
			currElements[i] = sol[i] = false;
		}
		
		TOWUtil(a, n, currElements, 0, sol, sum, 0, 0);
		
		System.out.println("First Subset is : ");
		for(int i = 0; i < n; i++)
			if(sol[i])
			System.out.print(a[i]+"\t");
		System.out.println();
		System.out.println("second Subset is : ");
		for(int i = 0; i < n; i++)
			if(!sol[i])
			System.out.print(a[i]+"\t");
		
	}
	
	public static void main(String[] args) {
		int a[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
		new TugOfWar().tugOfwar(a, a.length);
	}
}
