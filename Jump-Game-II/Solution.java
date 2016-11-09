public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        if(A == null || A.length == 0 || A[0] == 0){
            return -1;
        }

        //state
        int n = A.length;
        int[] state = new int[n];
        
        //initialize
        state[0] = 0;
        state[1] = 1;
        
        //function
        for(int i = 2; i < n; i++){
         int temp = Integer.MAX_VALUE;

            for(int j = 0; j < i; j++){
                if(j + A[j] >= i){
                    temp = Math.min(temp, state[j]);
                }
            }
            state[i] = temp + 1;
        }
        
        //answer
        return state[n-1];
    }
}
