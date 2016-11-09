public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        if(A == null || A.length() == 0 || B == null || B .length() == 0){
            return 0;
        }
        
        //state
        int n = A.length();
        int m = B.length();
        int[][] state = new int[n+1][m+1];
        
        //initialize
        for(int i = 0; i < state.length; i++){
            state[i][0] = 0;
        }
        for(int i = 0; i < state[0].length; i++){
            state[0][i] = 0;
        }
        
        
        //function
        for(int i = 1; i < state.length; i++){
            int max  = Integer.MIN_VALUE;
            for(int j = 1; j < state[0].length; j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    max = Math.max(state[i-1][j-1] + 1, state[i][j-1]);
                    state[i][j] = Math.max(max, state[i-1][j]);
                }else{
                    max = Math.max(state[i-1][j-1], state[i][j-1]);
                    state[i][j] = Math.max(max, state[i-1][j]);
                }
            }
        }
        
        //answer
        return state[n][m];
        
    }
}
