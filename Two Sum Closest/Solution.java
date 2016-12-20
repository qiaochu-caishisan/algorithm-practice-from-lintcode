public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumCloset(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int n = target - nums[i];
            int m = BinarySearchDifference(n, nums, i);
            
           min = Math.min(min, m);
        }
        return min;
    }
    public int BinarySearchDifference(int n, int[] nums, int i){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(n < nums[mid]){
                end = mid;
            }else if(n > nums[mid]){
                start = mid;
            }else{
                if(mid == i){
                    return Integer.MAX_VALUE;
                }else{
                    return 0;
                }
            }
        }
        if(start == i){
            return Math.abs(n - nums[end]);
        }
        if(end == i){
            return Math.abs(n - nums[start]);
        }
        return Math.min(Math.abs(n - nums[start]), Math.abs(n - nums[end]));
        
    }
}
