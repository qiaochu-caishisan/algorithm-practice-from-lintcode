public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        for(int i = 0; i < matrix.length; i++){
            int start = 0;
            int end = n - 1;
            
            while(start + 1 < end){
                int mid = start + (end - start)/2;
                
                if(target == matrix[i][mid]){
                    result++;
                    break;
                }else if(target < matrix[i][mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }
            
            if(matrix[i][start] == target){
                result++;
            }else if(matrix[i][end] == target){
                result++;
            }else{
                continue;
            }
            
        }
        return result;
    }
}
