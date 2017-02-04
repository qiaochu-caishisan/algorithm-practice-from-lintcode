class ResultType{
    public boolean exist;
    public int num;
    public ResultType(boolean a, int b){
        exist = a;
        num = b;
    }
}
public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        
        int left_pointer = matrix[0][0];
        int right_pointer = matrix[m][n];
        
        while(left_pointer <= right_pointer){
            int mid = left_pointer + (right_pointer - left_pointer)/2;
            ResultType temp = check(mid, matrix);
            if(temp.exist && temp.num == k){
                return mid;
            }else if(temp.num < k){
                left_pointer = mid + 1;
            }else{
                right_pointer = mid - 1;
            }
        }
        return left_pointer;
    }
    
    public ResultType check(int mid, int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int i = n - 1;
        int j = 0;
        boolean exist = false;
        int num = 0;
        while(i >= 0 && j < m){
            if(matrix[i][j] == mid){
                exist = true;
            }
            if(matrix[i][j] <= mid){
                num += i + 1;
                j += 1;
            }else{
                i -= 1;
            }
        }
        return new ResultType(exist, num);
    }
}
