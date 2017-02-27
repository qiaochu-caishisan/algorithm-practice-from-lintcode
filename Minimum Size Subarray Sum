public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if(nums.length == 0 || nums == null){
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        int j = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            while(j < nums.length && sum < s){
               sum += nums[j];
               j++;
            }
            if(sum >=s){
                if(j - i < ans){
                    ans = j - i;
                }
            }
            sum -= nums[i];
            
        }
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}
