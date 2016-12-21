public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    //prefix sum
    public int maxSubArray(int[] nums){
        int sum = 0;
        int minsum = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum - minsum);
            minsum = Math.min(sum, minsum);
            
        }
        return max;
    }
}
