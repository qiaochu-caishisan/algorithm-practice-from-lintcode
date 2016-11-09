public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        if(S == null || T == null){
            return 0;
        }
        
        //state
        int m = S.length();
        int n = T.length();
        
        int[][] state = new int[m+1][n+1];
        
        
        //initialize
        for(int i = 0; i < state.length; i++){
            state[i][0] = 1;
        }
        for(int j = 1; j < state[0].length; j++){
            state[0][j] = 0;
        }
        
        //function
        for(int i = 1; i < state.length; i++){
            for(int j = 1; j <= i && j < state[0].length; j++){
                if(S.charAt(i-1) == T.charAt(j-1)){
                    state[i][j] =  state[i-1][j-1] + state[i-1][j];
                }else{
                    state[i][j] = state[i-1][j];
                }
            }
        }
        
        return state[m][n];
    }
}
