public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
     class pair{
         int sum;
         int index;
         public pair(int x, int y){
             sum = x;
             index = y;
         }
     }
     
    public int[] subarraySumClosest(int[] nums) {
        int[] result = new int[2];
        
      if(nums == null || nums.length == 0){
          return result;
      }
      if(nums.length == 1){
          result[0] = 0;
          result[1] = 0;
          return result;
      }
      
      pair[] sums = new pair[nums.length + 1];
      int prev = 0;
      sums[0] = new pair(0,0);
      
      for(int i = 1; i <= nums.length; i++){
        sums[i] = new pair(prev + nums[i-1], i);
        prev = sums[i].sum;
      }
      
       Arrays.sort(sums, new Comparator<pair>() {
           public int compare(pair a, pair b) {
               return a.sum - b.sum;
           } 
        });
      
      int min = Integer.MAX_VALUE;
      for(int i = 1; i < sums.length; i++){
          if(sums[i].sum - sums[i-1].sum < min){
              min = sums[i].sum - sums[i-1].sum;
              int[] temp = new int[2];
              temp[0] = sums[i].index - 1;
              temp[1] = sums[i-1].index - 1;
              Arrays.sort(temp);
              result[0] = temp[0] + 1;
              result[1] = temp[1];
          }
      }
     
      return result;
      
    }
}
