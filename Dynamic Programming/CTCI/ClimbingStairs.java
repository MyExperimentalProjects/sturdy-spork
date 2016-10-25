class ClimbingStairs{
	final int BASE_STEP_1 = 1, BASE_STEP_2 = 2, BASE_STEP_3 = 3;
	int numSteps;

	ClimbingStairs(int steps){
		numSteps = steps;
	}

	public int waysToClimb(){
		int[] ways = new int[numSteps+1];
		ways[0] = 0;
		ways[BASE_STEP_1] = 1;
		ways[BASE_STEP_2] = 2;
		ways[BASE_STEP_3] = 4;
		for(int i = 4; i <= numSteps ; ++i){
			ways[i] = ways[i-BASE_STEP_1]+ ways[i-BASE_STEP_2] + ways[i-BASE_STEP_3];
		}
		return ways[numSteps];
	}

	public static void main(String[] args){
		ClimbingStairs c = new ClimbingStairs(10);
		System.out.println(c.waysToClimb());
	}
}