class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int length = A.length + B.length;
        int k = 0;
        double result = 0.0;
        if(length % 2 == 1){
            k = length/2 + 1;
            result = findKth(A, 0, B, 0, k);
        }
        if(length % 2 == 0){
            result = (findKth(A, 0, B, 0, length/2) + findKth(A, 0, B, 0, length/2 + 1))/2.0;
        }
        return result;
        
    }
    public int findKth(int[] A, int A_start, int[] B, int B_start, int k){
        if(A_start >= A.length){
            return B[B_start + k - 1];
        }
        if(B_start >= B.length){
            return A[A_start + k - 1];
        }
        if(k == 1){
            return Math.min(A[A_start], B[B_start]);
        }
        int A_key = A_start + k/2 - 1 < A.length ? A[A_start + k/2 - 1] : Integer.MAX_VALUE;
        int B_key = B_start + k/2 - 1 < B.length ? B[B_start + k/2 - 1]: Integer.MAX_VALUE;
        if(A_key < B_key){
            return findKth(A, A_start + k/2, B, B_start, k - k/2);
        }else{
            return findKth(A, A_start, B, B_start + k/2, k - k/2);
        }
    }
}
