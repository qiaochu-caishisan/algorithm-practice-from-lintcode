class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        int pl = 0;
        int pr = nums.length - 1;
        int i = 0;
        
        while(i <= pr){
             if(nums[i] == 0){
                swap(nums, pl, i);
                pl++;
                i++;
            }else if(nums[i] == 2){
                swap(nums, pr, i);
                pr--;
            }else{
                i++;
            }
        }
           
        
    }
    public void swap(int[] nums, int m, int n){
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
