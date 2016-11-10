public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        if(A == null | A.length == 0){
            return -1;
        }
        
        int start = 0;
        int end = A.length - 1;
        
        while(start + 1 < end){
            int mid =  start + (end - start)/2;
            
            if(target == A[mid]){
                return mid;
            }
            if(target < A[mid]){
                end = mid;
            }
            if(target > A[mid]){
                start = mid;
            }
            
        }
        
        if(Math.abs(target - A[start]) <= Math.abs(target - A[end])){
            return start;
        }else{
            return end;
        }
    }
}
