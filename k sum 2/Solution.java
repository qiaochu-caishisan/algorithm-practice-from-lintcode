public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        
        if(A.length == 0 || A == null){
            result.add(path);
            return result;
        }
        Arrays.sort(A);
        helper(result, path, A, k, target, 0);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, int[] A, int k, int target, int index){
        
        if( k == 0 && target == 0){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        if(k == 0 || target == 0){
            return;
        }
        if(k < 0 || target < 0 || index > A.length - 1){
            return;
        }
        for(int i = index; i < A.length; i++){
            // if(path.contains(A[i])){
            //     continue;
            // }
            path.add(A[i]);
            helper(result, path, A, k - 1, target - A[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
}
