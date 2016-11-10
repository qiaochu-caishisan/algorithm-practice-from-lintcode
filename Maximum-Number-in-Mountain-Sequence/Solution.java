public class Solution {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     */
    public int mountainSequence(int[] nums) {
        int start = 0;
        int end  = nums.length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return nums[mid];
            }else if(nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if(nums[start] > nums[end]){
            return nums[start];
        }else{
            return nums[end];
        }
    }
}
