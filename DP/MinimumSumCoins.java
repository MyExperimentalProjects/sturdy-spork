/*
Given a list of N coins, their values (V1, V2, … , VN), and the total sum S. 
Find the minimum number of coins the sum of which is S (we can use as many coins of one type as we want), 
or report that it’s not possible to select coins in such a way that they sum up to S.
*/
class MinimumSumCoins{

	private int sum;
	private int[] coins;
	private int[] memoSum;

	MinimumSumCoins(int sum,int[] coins){
		this.sum = sum;
		this.coins = coins;
		this.memoSum = new int[sum+1];
	}

	public int getMinimumCoins(){
		memoSum[0] = 0;
		for(int currSum = 1; currSum <= sum; ++currSum){
			int minCoins = Integer.MAX_VALUE;
			for(int j = 0; j < coins.length; ++j){
				if(coins[j] <= currSum){
					int temp = 1 + memoSum[currSum-coins[j]];
					if(temp < minCoins){
						minCoins = temp;
					}
				}
			}
			memoSum[currSum] = minCoins;
		}
		return memoSum[sum];
	}

	public static void main(String args[]){
		int[] coins = {1,3,5};
		MinimumSumCoins minimumSumCoins = new MinimumSumCoins(11,coins);
		System.out.println("The minimum number of coins required are - " + minimumSumCoins.getMinimumCoins());
	}
}