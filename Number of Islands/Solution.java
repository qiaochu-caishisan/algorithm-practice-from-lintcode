public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]){
                    count++;
                    helper(grid, i, j);
                }
            }
        }
        return count;
    }
    public void helper(boolean[][] grid, int row, int column){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length){
            return;
        }
        if(grid[row][column]){
        grid[row][column] = false;
        helper(grid, row - 1, column);
        helper(grid, row + 1, column);
        helper(grid, row, column - 1);
        helper(grid, row, column + 1);
        }
        
    }
}
