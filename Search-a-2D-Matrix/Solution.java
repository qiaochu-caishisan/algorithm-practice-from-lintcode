public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int n = 1;
        while(n < matrix.length){
            if (target == matrix[n][0]){
                return true;
            }else if (target > matrix[n][0]){
                n++;
            }else{
                break;
            }
                
        }
        
        n = n - 1;
        int start = 0;
        int end = matrix[0].length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            
            if(matrix[n][mid] == target){
                return true;
            }else if(target < matrix[n][mid]){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(matrix[n][start] == target){
            return true;
        }else if(matrix[n][end] == target){
            return true;
        }else{
            return false;
        }

    }
}
