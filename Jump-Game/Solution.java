public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        if(A == null || A.length == 0){
            return true;
        }
        
        //state
        int n = A.length;
        boolean[] state = new boolean[n];
        
        //initialize
        state[0] = true;
        
        //function
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i;j++){
                if(state[j] == true){
                    if(j + A[j] >= i){
                        state[i] = true;
                    }
                }
            }
            
        }
        
        return state[n-1];
    }
}
