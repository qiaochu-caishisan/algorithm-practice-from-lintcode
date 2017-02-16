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
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        int left_pointer = A[0] + B[0];
        int right_pointer = A[A.length - 1] + B[B.length - 1];
        while(left_pointer <= right_pointer){
            int mid = left_pointer + (right_pointer - left_pointer)/2;
            ResultType temp = check(mid, A, B);
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
    public ResultType check(int mid, int[] A, int[] B){
        int n = A.length;
        int m = B.length;
        int i = n - 1;
        int j = 0;
        boolean exist = false;
        int num = 0;
        while(i >= 0 && j < m){
            if(A[i] + B[j] == mid){
                exist = true;
            }
            if(A[i] + B[j] <= mid){
                num += i + 1;
                j += 1;
            }else{
                i -= 1;
            }
        }
        return new ResultType(exist, num);
    }
}
