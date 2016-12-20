class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int start = 0;
        int end = nums.length - 1;
        
        quickSort(nums, start, end);
    }
    
    public void quickSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int left = start;
        int right = end;
        int pivot = nums[(start+end)/2];
        
        while(left <= right){
            while(left <= right && nums[left] < pivot){
                left++;
            }
            while(left <= right && nums[right] > pivot){
                right--;
            }
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }
}
