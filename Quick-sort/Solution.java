public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
     //quick sort
     public void sortIntegers2(int[] A){
         if(A == null || A.length == 0){
             return;
         }
         int start = 0;
         int end = A.length - 1;
         quickSort(A, start, end);
     }
     private void quickSort(int[] A, int start, int end){
         if(start >= end){
             return;
         }
         int left = start;
         int right = end;
         int pivot = A[(start + end)/2];
         while(left <= right){
         while(left <= right && A[left] < pivot){
             left++;
         }
         while(left <= right && A[right] > pivot){
             right--;
         }
          if(left <= right){
             int temp = A[right];
             A[right] = A[left];
             A[left] = temp;
             left++;
             right--;
          }
    }
         
         quickSort(A, start, right);
         quickSort(A, left, end);
         
         
     }
    
}
    
    /**mergesort
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

*/
