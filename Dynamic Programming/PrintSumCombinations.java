class PrintSumCombinations{
	public static void printway(int[] arr, int size){
		System.out.println();
		for(int i = 0 ; i < size ; ++i){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void ways(int n, int k, int[] way, int max_points){
		
		if(n == 0){
			printway(way,k);
			return;
		}
		if(n < 0){
			return;
		}
		for(int i = 1 ; i < max_points ; ++i){
			way[k] = i;
			ways(n-i,k+1,way,max_points);
		}
	}
	public static void main(String[] args){
		int[] way = new int[10000];
		ways(3, 0, way, 3);
	}
}