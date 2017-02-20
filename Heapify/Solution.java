public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        for(int i = A.length/2; i >= 0; i--){
            minHeapify(A, i);
        }
    }
    public void minHeapify(int[] A, int index){
        
        int l = index * 2 + 1;
        int r = index * 2 + 2;
        if(l >= A.length && r >= A.length){
            return;
        }
        int min = 0;
        if(l < A.length && A[l] < A[index]){
            min = l;
        }else{
            min = index;
        }
        if(r < A.length && A[r] < A[min]){
            min = r;
        }
        if(min != index){
            int temp = A[min];
            A[min] = A[index];
            A[index] = temp;
            minHeapify(A, min);
        }
        
    }
}
