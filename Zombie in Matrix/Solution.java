class matrixIndex{
    int row;
    int column;
    int day;
    public matrixIndex(int a, int b, int c){
        row = a;
        column = b;
        day = c;
    }
}
public class Solution {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */

    public int zombie(int[][] grid) {
        Queue<matrixIndex> matrixQueue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    matrixQueue.offer(new matrixIndex(i, j, 0));
                }
            }
        }
        int max = 0;
        while(!matrixQueue.isEmpty()){
            Queue<matrixIndex> queue = new LinkedList<>();
            matrixIndex element = matrixQueue.poll();
            if(element.row != 0){
                if(grid[element.row - 1][element.column] == 0){
                    queue.add(new matrixIndex(element.row - 1, element.column, element.day + 1));
                }
            }
            if(element.column != 0){
                if(grid[element.row][element.column - 1] == 0){
                    queue.add(new matrixIndex(element.row, element.column - 1, element.day + 1));
                }
            }
            if(element.row < grid.length - 1){
                if(grid[element.row + 1][element.column] == 0){
                    queue.add(new matrixIndex(element.row + 1, element.column, element.day + 1));
                }   
            }
            if(element.column < grid[0].length - 1){
                if(grid[element.row][element.column + 1] == 0){
                    queue.add(new matrixIndex(element.row, element.column + 1, element.day + 1));
                }
            }
            
            while(!queue.isEmpty()){
                matrixIndex human = queue.poll();
                grid[human.row][human.column] = 1;
                matrixQueue.offer(new matrixIndex(human.row, human.column, human.day));
                if(human.day > max){
                    max = human.day;
                }
            }
            
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    return -1;
                }
            }
        }
        return max;
        
    }
}
