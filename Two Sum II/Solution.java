public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int left_pointer = 0;
        int right_pointer = nums.length - 1;
        int count = 0;
        Arrays.sort(nums);
        while(left_pointer < right_pointer){
            if(nums[left_pointer] + nums[right_pointer] > target){
                count += right_pointer - left_pointer;
                right_pointer--;
            }else if(nums[left_pointer] + nums[right_pointer] == target){
                left_pointer++;
            }else{
                left_pointer++;
            }
        }
        return count;
    }
}
