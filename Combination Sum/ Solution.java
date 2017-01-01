public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        if(candidates == null){
            return result;
        }
        helper(candidates, target, result, 0, path);
        
        return result;
        
    }
    public void helper(int[] candidates, int target, List<List<Integer>> result, int index, List<Integer> path){
        if(target == 0){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        int prev = -1;
        for(int i = index; i < candidates.length; i++){
            if(candidates[i] > target){
                break;
            }
            //为了删掉一个元素之后第二次不会继续选择这个元素
            if(prev != -1 && prev == candidates[i]){
                continue;
            }
            
            int num = target - candidates[i];
            path.add(candidates[i]);
            //每一次都从i位往后找 这样的话 就能保证不会有重复的辣
            helper(candidates, num, result, i, path);
            path.remove(path.size() - 1);
            prev = candidates[i];
        }
    }
}
