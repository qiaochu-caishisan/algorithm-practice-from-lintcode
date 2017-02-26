public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
     //quick sort
    public void sortIntegers2(int[] A) {
        // Write your code here
        if(A.length == 0 || A == null){
            return;
        }
        quicksort(A, 0, A.length - 1);
    }
    public void quicksort(int[] A, int l, int r){
        if(l >= r){
            return;
        }
        
        int partition_index = partition(A, l, r);
        
            quicksort(A, l, partition_index - 1);
        
        
            quicksort(A, partition_index, r);
        
        
    }
    public int partition(int[] A, int l, int r){
         Random rand= new Random();
         int pivot = A[rand.nextInt(r - l + 1) + l];
        int left = l;
        int right = r;
        while(left <= right){ 
            while( A[left] < pivot){
                left++;
            }
            while( A[right] > pivot){
                right--;
            }
            if(left <= right){
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
           
            
        }
        
        return left;
    }
}
