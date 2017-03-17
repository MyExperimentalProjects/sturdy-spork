/*
https://leetcode.com/problems/maximum-subarray
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

Reference -
http://algorithms.tutorialhorizon.com/dynamic-programming-maximum-subarray-problem/
https://tkramesh.wordpress.com/2011/03/09/dynamic-programming-maximum-sum-contiguous-subsequence/
*/

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] sum = new int[nums.length];
        int[] indices = new int[nums.length];
        sum[0] = nums[0];
        indices[0] = 0;
        for(int i = 1 ; i < nums.length ; ++i){
            if(sum[i-1]+nums[i] >= nums[i]){
                sum[i] = sum[i-1]+nums[i];
            }else{
                sum[i] = nums[i];
                indices[i] = i;
            }
            
        }
        int maxSum = sum[0];
        int index = 0;
        for(int j = 1 ; j < sum.length ; ++j){
            if(sum[j] >= maxSum){
                maxSum = sum[j];
                index = j;
            }
        }
        return maxSum;
    }
}
