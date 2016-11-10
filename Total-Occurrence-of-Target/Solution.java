public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        if(A == null ||A.length == 0){
            return 0;
        }
        int front = 0;
        int rear = 0;
        int start  = 0;
        int end = A.length - 1;
        int start1 = 0;
        int end1 = A.length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(target == A[mid]){
                end = mid;
            }else if(target < A[mid]){
                end = mid;
            }else{
                start = mid;
            }
        }
        
        if(A[start] == target){
            front = start;
        }else if(A[end] == target){
            front = end;
        }else{
            front = -1;
        }
        if(front != -1){
            while(start1 + 1 < end1){
            int mid = start1 + (end1 - start1)/2;
            if(target == A[mid]){
                start1 = mid;
            }else if(target < A[mid]){
                end1 = mid;
            }else{
                start1 = mid;
            }
        }
         if(A[end1] == target){
            rear = end1;
        }else if(A[start1] == target){
            rear = start1;
        }
    }else{
        return 0 ;
    }
    if(front == rear){
        return 1;
    }else{
        return rear - front + 1;
    }
        
        
    }
}
