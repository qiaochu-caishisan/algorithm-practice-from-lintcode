public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int[]  result = new int[2];
        if(A == null || A.length == 0){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        
        int start = 0;
        int end = A.length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            
            if(A[mid] < target){
                start = mid;
            }else {
                end = mid;
            }
        }
        
        if(A[start] == target){
            result[0] = start;
        }else if(A[end] == target){
            result[0] = end;
        }else{
            result[0] = -1;
        }
        
        int start1 = result[0];
        int end1 = A.length - 1;
        while(start1 + 1 < end1){
            int mid = start1 + (end1 - start1)/2;
            
            if(A[mid] <= target){
                start1 = mid;
            }else{
                end1 = mid;
            }
        }
        
        if(A[end1] == target){
            result[1] = end1;
        }else if(A[start1] == target){
            result[1] = start1;
        }else{
            result[1] = -1;
        }
        
        return result;
        
    }
}
