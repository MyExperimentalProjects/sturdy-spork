class PaintHouse{
	
	public static int minCost(int[][] costs) {
		int minimumCost = 0;
		int numHouses = costs.length;
		int RED_COST_INDEX = 0, GREEN_COST_INDEX = 1, BLUE_COST_INDEX = 2;
		int i = 0;
		for(i = 1 ; i < numHouses ; ++i){
			costs[i][RED_COST_INDEX] += Math.min(costs[i-1][GREEN_COST_INDEX], costs[i-1][BLUE_COST_INDEX]);
			costs[i][GREEN_COST_INDEX] += Math.min(costs[i-1][RED_COST_INDEX], costs[i-1][BLUE_COST_INDEX]);
			costs[i][BLUE_COST_INDEX] += Math.min(costs[i-1][GREEN_COST_INDEX], costs[i-1][RED_COST_INDEX]); 
		}
		minimumCost =  Math.min(Math.min(costs[i-1][RED_COST_INDEX],costs[i-1][GREEN_COST_INDEX]),costs[i-1][BLUE_COST_INDEX]);
		return minimumCost;
	}
	public static void main(String[] args){
		int[][] costs = {{7,5,10},{3,6,1},{8,7,4},{6,2,9},{1,4,7},{2,3,6}};
		System.out.println(minCost(costs));
	}
}
