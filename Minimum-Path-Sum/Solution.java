public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return -1;
        }
        if(grid[0] == null || grid[0].length == 0){
            return -1;
        }
        //state
        int m = grid.length;
        int n = grid[0].length;
        int[][] state = new int[m][n];
        
        //initialize
        state[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            state[i][0] = state[i-1][0] + grid[i][0];
        }
        for(int j = 1; j < n; j++){
            state[0][j] = state[0][j-1] + grid[0][j];
        }
        
        //function
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                state[i][j] = Math.min(state[i-1][j], state[i][j-1]) + grid[i][j];
            }
        }
        
        return state[m-1][n-1];
        
    }
}
