public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        if(A == null || B == null) {
            return 0;
        }
        
        //state
        int m = A.length();
        int n = B.length();
        int[][] state = new int[m+1][n+1];
        
        //initialize
        state[0][0] = 0;
        for(int i = 1; i < state.length; i++){
            state[i][0] = 0;
        }
        for(int j = 1; j < state[0].length; j++){
            state[0][j] = 0;
        }
        
        //function
        for(int i = 1; i < state.length; i++){
            for(int j = 1; j < state[0].length; j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    state[i][j] = state[i-1][j-1] + 1;
                }else{
                    state[i][j] = 0;
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < state.length; i++){
            for(int j = 0; j < state[0].length; j++){
                max = Math.max(max, state[i][j]);
            }
        }
        return max;
    }
}
