class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int index = 0;
        for(int i = m; i < m+n; i++){
            A[i] = B[index++];
        }
        
        Arrays.sort(A);
    }
}
