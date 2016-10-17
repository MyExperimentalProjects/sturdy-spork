import java.util.*;

class KnapSack{
	private static int knapsack(int n, int[] val, int[] weight, int W){
		if(n <= 0 || W <= 0){
			return 0;
		}
		if(weight[n-1] > W){
			return knapsack(n-1,val,weight,W);
		}
		int whenNincluded = knapsack(n-1,val,weight,W-weight[n-1]) + val[n-1];
		int whenNnotIncluded = knapsack(n-1,val,weight,W);
		return Math.max(whenNincluded, whenNnotIncluded);
	}

	private static int knapsackBottomUP(int n, int[] val, int[] weight, int W){
		int[][] K = new int[n+1][W+1];
		int[][] keep = new int[n+1][W+1];
		for(int i = 0; i <= n ; ++i){
			for(int w = 0; w <= W ; ++w){
				if(i == 0 || w == 0){
					K[i][w] = 0;
					keep[i][w] = 0;
				}
				else if(weight[i-1] > w){
					K[i][w] = K[i-1][w];
					keep[i][w] = 0;
				}else{
					int whenIncluded = K[i-1][w-weight[i-1]]+val[i-1];
					int whenNotIncluded = K[i-1][w];
					if(whenIncluded > whenNotIncluded){
						keep[i][w] = 1;
					}else{
						keep[i][w] = 0;
					}
					K[i][w] = Math.max(whenIncluded,whenNotIncluded);
				}
			}
		}

		for(int i = 1 ; i < n ; ++i){
			if(keep[i][W] == 1){
				System.out.println(i);
			}
		}
		return K[n][W];
	}

	public static void main(String[] args){
		int[] values = {60,100,120};
		int[] weight = {10,20,30};
		int W = 50;
		//System.out.println(knapsack(weight.length,values,weight,W));
		System.out.println(knapsackBottomUP(weight.length,values,weight,W));
	}
}
