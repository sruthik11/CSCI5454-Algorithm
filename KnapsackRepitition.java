// Java program to find the maximum achievable value that can fit in a knapsack of weight W where repetition of an item is allowed.
public class KnapsackRepitition
{
//Funnction to provide the max output out of the two inputs
	private static int max(int comp1, int comp2)
	{
			return (comp1 > comp2) ?  comp1 : comp2;
	}

	// Return the maximum value possible for a knapsack of W capacity
	private static int knapsackRepitition(int W, int len,
								int[] v, int[] w)
	{

		//Subproblem: Find the maximum value that can be stored in S[i] for a knapsack capacity of i where i = 0,1,2..,W
		//Base Case: S[0] = 0, this means that for a knapsack capacity = 0 the maximum value that can be stored is = 0 since no value can fit in.

		// Every element in S[] array is initialized to zero.
		int S[] = new int[W + 1];

		// Inductive Case: S[i] = max(S[i-1], S[i-wt[j]] + val[j]). There are 2 possibilities -
		// 1. S[i] = S[i-1] means that the opitimal solution for a knapsack of size i-1 can fit in a knapsack of size i.
		// 2. S[i] = S[i-wt[j]] + val[j] means that if for a knapsack of size i we fit item j then the remaining size is i-wt[j]
		// and the maximum value S[i-wt[j]] is a subproblem that has already been computed optimally.

		//Thus compare both possibilities and consider the maximum of it.
		for(int i = 1; i <= W; i++){
			S[i] = S[i-1];
			for(int j = 0; j < len; j++){
				if(w[j] <= i){
					S[i] = max(S[i], S[i - w[j]] +
								v[j]);
				}
			}
		}
		//Final Computation: S[W]. This will return the optimal solution for a knapsack of capacity W
		//since all the previous subproblems are solved optimally and then only we compute for S[W].
		return S[W];
	}

	// Driver program
	public static void main(String[] args)
	{
		//test
		int W2= 100;
    int v1[] = { 10, 30, 20 };
    int w1[] = { 5, 10, 15 };
		int len1 = v1.length;
		int v[] = {2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
		int w[] = {2, 2, 3, 4, 7, 12, 20, 33, 54, 88};
		int len = v.length;
		// Part 1.
		int W = 10830;
		// Part 2.
		int W1 = 108300697;
		System.out.println("For a Knapsack of Size = "+ Integer.toString(W2)+" Maximum Value = "+ knapsackRepitition(W2, len1, v1, w1));
		System.out.println("For a Knapsack of Size = "+ Integer.toString(W)+" Maximum Value = "+ knapsackRepitition(W, len, v, w));
		System.out.println("For a Knapsack of Size = "+ Integer.toString(W1)+" Maximum Value = "+ knapsackRepitition(W1, len, v, w));
	}
}
