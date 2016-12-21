public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    int pl = 0;
	    int pr = nums.length - 1;
	    int i = 0;
	    while(i <= pr){
	        if(nums[i] < k){
	            swap(nums, i, pl);
	            pl++;
	            i++;
	        }else{
	            swap(nums, i, pr);
                pr--;
	        }
	    }
	    for(int m = 0; m < nums.length; m++){
	        if(nums[m] >= k){
	            return m;
	        }
	    }
	    return nums.length;
    }
    public void swap(int[] nums, int i, int pointer){
        int temp = nums[i];
        nums[i] = nums[pointer];
        nums[pointer] = temp;
    }
}
