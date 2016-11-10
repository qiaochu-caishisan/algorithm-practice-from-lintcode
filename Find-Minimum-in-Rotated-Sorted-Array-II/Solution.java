public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        int start = 0;
        int end = num.length - 1;
        int target = num[end];
        boolean a = false;
      
         
         while(start + 1 < end){
             int mid = start + (end - start)/2;
             if(num[mid] < target){
                 end = mid;
             }else if(num[mid] > target){
                 start = mid;
             }else{
                 for(int i = mid; i <= end; i++){
                     if(num[i] < num[mid]){
                         a = true;
                         break;
                     }else{
                         a = false;
                     }
                 }
                 if(a){
                     start = mid;
                 }else{
                     end = mid;
                 }
             }
         }
         
         if(num[start] < target){
             return num[start];
         }else{
             return num[end];
         }
         
         

    }
}
