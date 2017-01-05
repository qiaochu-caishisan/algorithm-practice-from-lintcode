class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] visited = new int[nums.length];
        
        if(nums == null || nums.length == 0){
            result.add(path);
            return result;
        }
        
        helper(result, path, nums, visited);
        return result;
    }
    public void helper(List<List<Integer>> result, List<Integer> path, int[] nums, int[] visited){
        //这里就相当于规定一个出口 这个出口很关键 但是subsets类的问题没有出口
        if(path.size() == nums.length){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        //其实这里可以用检测path中是否已存在来代替
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == 1){
                continue;
            }
            path.add(nums[i]);
            visited[i] = 1;
            helper(result, path, nums, visited);
            path.remove(path.size() - 1);
            visited[i] = 0;
        }
    }
}
