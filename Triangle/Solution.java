public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        int min = Integer.MAX_VALUE;
        if(triangle == null || triangle.length == 0){
            return -1;
        }
        if(triangle[0] == null || triangle[0].length == 0){
            return -1;
        }
        //state
        int n = triangle.length;
        int[][] state = new int[n][n];
        
        //initialize
        state[0][0] = triangle[0][0];
        for(int i = 1; i < n; i++){
            state[i][0] = state[i-1][0] + triangle[i][0];
            state[i][i] = state[i-1][i-1] + triangle[i][i];
        }
        
        //function(top-down)
        for(int i = 1; i < n; i++){
            for(int j = 1; j < i; j++){
                state[i][j] = Math.min(state[i-1][j-1], state[i-1][j]) + triangle[i][j];
            }
            
        }
        
        
        //answer
        for(int j = 0; j < n; j++){
            if(state[n - 1][j] < min){
                min = state[n - 1][j];
            }
        }
        return min;
        
    }
}
