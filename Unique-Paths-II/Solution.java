public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1){
            return 0;
        }
        
        
        
        //state
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] state = new int[row][column];
        
        //initialize
        state[0][0] = 1;
        for(int i = 0; i < row - 1; i++){
            if(obstacleGrid[i][0] == 0){
                state[i+1][0] = 1;
            }else{
                for(int m = i; m < row; m++){
                    state[m][0] = 0;
                }
                break;
            }
        }
        for(int j = 0; j < column - 1; j++){
            if(obstacleGrid[0][j] == 0){
                state[0][j+1] = 1;
            }else{
               for(int n = j; j < column; j++){
                   state[0][n] = 0;
               }
               break;
            }
        }
        
        //function
        for(int i = 1; i < row; i++){
            for(int j = 1; j < column; j++){
                if(obstacleGrid[i][j] == 1){
                    state[i][j] = 0;
                }
                else{
                    state[i][j] = state[i-1][j] + state[i][j-1];
                }
            }
        }
        
        //answer
        return state[row-1][column-1];
        
        
    }
}
