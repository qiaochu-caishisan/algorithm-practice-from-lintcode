public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        int[] result = new int[k];
        
        if(A == null || A.length == 0 || k > A.length){
            return A;
        }
        
        int start = 0;
        int end = A.length - 1;
        int index = 0;
         
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            
            if(target == A[mid]){
                end = mid;
            }else if(target <  A[mid]){
                end = mid;
            }else{
                start = mid;
            }
        }
        
        if(A[start] >= target){
            index = start;
        }else if(A[end] >= target){
            index = end;
        }else{
            index = A.length;
        }
        
        int front = index - 1;
        int rear = index;
        
        for(int i = 0; i < k; i++){
            if(front < 0){
                result[i] = A[rear++];
            }else if(rear >= A.length){
                result[i] = A[front--];
            }else{
                if(target - A[front] <= A[rear] - target){
                    result[i] = A[front--];
                }else{
                    result[i] = A[rear++];
                }
            }
        }
        return result;
        
    }
}
