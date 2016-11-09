public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        if(word1 == null ||  word2 == null ){
            return 0;
        }
        
        //state
        int m = word1.length();
        int n = word2.length();
        int[][] state = new int[m+1][n+1];
        
        //initialize
        for(int i = 0; i < state.length; i++){
            state[i][0] = i;
        }
        for(int j = 0; j < state[0].length; j++){
            state[0][j] = j;
        }
        
        //function
        for(int i = 1; i < state.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j < state[0].length; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    min = Math.min(state[i-1][j-1], state[i-1][j] + 1);
                    state[i][j] = Math.min(min, state[i][j-1] + 1);
                }else{
                    min = Math.min(state[i-1][j-1] + 1, state[i][j-1] + 1);
                    state[i][j] = Math.min(min, state[i-1][j] + 1);
                }
            }
        }
        
        //answer
        return state[m][n];
        
        
    }
}
