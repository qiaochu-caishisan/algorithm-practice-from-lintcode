class cell{
    int x;
    int y;
    int height;
    public cell(int a, int b, int c){
        x = a;
        y = b;
        height = c;
    }
}
class cellComparator implements Comparator<cell>{
    public int compare(cell a, cell b){
        if(a.height > b.height){
            return 1;
        }else if(a.height == b.height){
            return 0;
        }else{
            return -1;
        }
    }
}
public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        // write your code here
        if(heights == null || heights.length == 0){
            return 0;
        }
        
        PriorityQueue<cell> queue = new PriorityQueue<cell>(1, new cellComparator());
        int row = heights.length;
        int column = heights[0].length;
        int[][] visited = new int [row][column];
        for(int i = 0; i < heights[0].length; i++){
            queue.offer(new cell(0, i, heights[0][i]));
            queue.offer(new cell(row - 1, i, heights[row-1][i]));
            visited[0][i] = 1;
            visited[row-1][i] = 1;
        }
        for(int i = 0; i < heights.length; i++){
            queue.offer(new cell(i, 0, heights[i][0]));
            queue.offer(new cell(i, column - 1, heights[i][column - 1]));
            visited[i][0] = 1;
            visited[i][column-1] = 1;
        }
        int[] dx = {0, -1, 1, 0};
        int[] dy = {1, 0, 0, -1};
        int result = 0;
        while(!queue.isEmpty()){
            cell temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < row && ny >= 0 && ny < column && visited[nx][ny] == 0){
                    visited[nx][ny] = 1;
                    queue.offer(new cell(nx, ny, Math.max(heights[nx][ny], temp.height)));
                    result += Math.max(0, temp.height - heights[nx][ny]);
                    
                }
                
                
            }
        }
        return result;
    }
};
