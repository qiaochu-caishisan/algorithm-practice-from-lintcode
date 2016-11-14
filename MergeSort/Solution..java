public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }
    private void mergeSort(int[] A, int start, int end, int[] temp){
        if(start >= end){
            return;
        }
        int mid = start + (end - start)/2;
        mergeSort(A, start, mid, temp);
        mergeSort(A, mid + 1, end, temp);
        merge(A, start, mid, end, temp);
    }
    private void merge(int[] A, int start, int mid, int end, int[] temp){
        int left = start;
        int right = mid + 1;
        int index = start;
        
        while(left <= mid && right <= end){
            if(A[left] < A[right]){
                temp[index] = A[left];
                index++;
                left++;
            }else{
                temp[index] = A[right];
                right++;
                index++;
            }
        }
        
        while(left <= mid){
            temp[index] = A[left];
            index++;
            left++;
        }
        while(right <= end){
            temp[index] = A[right];
            index++;
            right++;
        }
        
        for(int i = start;  i <= end; i++){
            A[i] = temp[i];
        }
    }
}
