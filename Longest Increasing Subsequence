public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int answer = Integer.MIN_VALUE;;
        //state 到第I个最长子序列是多少个
        int n = nums.length;
        int[] state = new int[n];
        
        //initialize
        state[0] = 1;
        
        //function
        for(int i = 1; i < n; i++){
            int temp = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    temp = Math.max(temp, state[j]);
                }
            }
            
            state[i] = temp + 1;
        }
        
        //answer
        for(int i = 0; i < n; i++){
            answer = Math.max(answer, state[i]);
        }
        return answer;
    }
}
