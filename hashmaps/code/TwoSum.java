import java.util.HashMap;

public class TwoSum{
	
	public static int[] twoSum(int[] nums, int target) {
		if(nums.length == 0){
			throw new IllegalArgumentException();
		}
		HashMap<Integer,Integer> storeIndices = new HashMap<>();
		for(int i = 0 ; i < nums.length ; ++i){
			int diff = target - nums[i];
			if(storeIndices.containsKey(diff) && storeIndices.get(diff) != i){
				return new int[]{storeIndices.get(diff),i};
			}
			storeIndices.put(nums[i],i);
		}
		throw new IllegalArgumentException();
	}

	public static void main(String[] args){
		int[] nums = new int[]{-3, 7, 11, -5};
		int target = -8;
		int[] op = twoSum(nums,target);
		System.out.println(op[0]+","+op[1]);
	}
}
