public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0){
            return 0;
        }
            
        int start = 0;
        int end = A.length - 1;
        
        while(start + 1 < end){
        int mid = start + (end - start)/2;
            if(target == A[mid]){
                return mid;
            }else if(target < A[mid]){
                end = mid;
            }
            else{
                start =  mid;
            }
        }
        if(target <= A[start]){
            return start;
        }else if(target <= A[end]){
            return end;
        }
        else{
            return end + 1;
        }
    }
}
