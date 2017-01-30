/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if(grid == null || grid.length == 0){
            return -1;
        }
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        HashMap<Point, Integer> levelMap = new HashMap<>();
        levelMap.put(source, 0);
        
        while(!queue.isEmpty()){
            Point point = queue.poll();
            Point temp1 = new Point(point.x - 2, point.y + 1);
            Point temp2 = new Point(point.x - 1, point.y + 2);
            Point temp3 = new Point(point.x + 1, point.y + 2);
            Point temp4 = new Point(point.x + 2, point.y + 1);
            Point temp5 = new Point(point.x - 1, point.y - 2);
            Point temp6 = new Point(point.x - 2, point.y - 1);
            Point temp7 = new Point(point.x + 1, point.y - 2);
            Point temp8 = new Point(point.x + 2, point.y - 1);
            
            if(check(temp1, grid)){
               
                if(grid[temp1.x][temp1.y] != true){
                    levelMap.put(temp1, levelMap.get(point) + 1);
                    if(temp1.x == destination.x && temp1.y == destination.y){
                        return levelMap.get(temp1);
                    }
                queue.offer(temp1);
                grid[temp1.x][temp1.y] = true;
                }  
            } 
            
            if(check(temp2, grid)){
               if(grid[temp2.x][temp2.y] != true){
                levelMap.put(temp2, levelMap.get(point) + 1);
                if(temp2.x == destination.x && temp2.y == destination.y){
                    return levelMap.get(temp2);
                }
                queue.offer(temp2);
                grid[temp2.x][temp2.y] = true;
                } 
            } 
            if(check(temp3, grid)){
               if(grid[temp3.x][temp3.y] != true){
                levelMap.put(temp3, levelMap.get(point) + 1);
                //if(temp3 == destination){
                if(temp3.x == destination.x && temp3.y == destination.y){
                    return levelMap.get(temp3);
                }
                queue.offer(temp3);
                grid[temp3.x][temp3.y] = true;
                } 
            } 
            if(check(temp4, grid)){
                
                if(grid[temp4.x][temp4.y] != true){
                levelMap.put(temp4, levelMap.get(point) + 1);
                if(temp4.x == destination.x && temp4.y == destination.y){
                    return levelMap.get(temp4);
                }
                queue.offer(temp4);
                grid[temp4.x][temp4.y] = true;
            }
            } 
            if(check(temp5, grid)){
               if(grid[temp5.x][temp5.y] != true){
                levelMap.put(temp5, levelMap.get(point) + 1);
                if(temp5.x == destination.x && temp5.y == destination.y){
                    return levelMap.get(temp5);
                    
                }
                queue.offer(temp5);
                grid[temp5.x][temp5.y] = true;
            } 
            } 
            if(check(temp6, grid)){
                if(grid[temp6.x][temp6.y] != true){
                levelMap.put(temp6, levelMap.get(point) + 1);
                if(temp6.x == destination.x && temp6.y == destination.y){
                    return levelMap.get(temp6);
                }
                queue.offer(temp6);
                grid[temp6.x][temp6.y] = true;

            }
            } 
            if(check(temp7, grid)){
                 if(grid[temp7.x][temp7.y] != true){
                levelMap.put(temp7, levelMap.get(point) + 1);
                if(temp7.x == destination.x && temp7.y == destination.y){
                    return levelMap.get(temp7);
                }
                queue.offer(temp7);
                grid[temp7.x][temp7.y] = true;
            }
            }
            if(check(temp8, grid)){
               if(grid[temp8.x][temp8.y] != true){
                levelMap.put(temp8, levelMap.get(point) + 1);
                if(temp8.x == destination.x && temp8.y == destination.y){
                    return levelMap.get(temp8);
                }
                queue.offer(temp8);
                grid[temp8.x][temp8.y] = true;
                } 
            }
                
               
        }
        return -1;
    }
    
    public boolean check(Point point, boolean[][] grid){
        if(point.x < grid.length && point.y < grid[0].length && point.x >= 0 &&
        point.y >= 0){
            return true;
        }else{
            return false;
        }
    }
    
}
