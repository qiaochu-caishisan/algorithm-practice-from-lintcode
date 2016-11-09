public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0){
            return -1;
        }
        
        //state
        int[][]state = new int[m][n];
        
        //initialize
        state[0][0] = 0;
        for(int i = 1; i < m; i++){
            state[i][0] = 1;
        }
        for(int j = 1; j < n; j++){
            state[0][j] = 1;
        }
        
        //function
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                state[i][j] = state[i-1][j] + state[i][j-1];
            }
        }
        
        //answer
        return state[m-1][n-1];
    }
}
