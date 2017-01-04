class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        if(nums == null || nums.length == 0){
            result.add(path);
            return result;
        }
        int[] visited = new int[nums.length];
        for(int i = 0; i < visited.length; i++){
            visited[i] = 0;
        }
        Arrays.sort(nums);
        helper(result, path, nums, visited);
        return result;
    } 
    
    public void helper( List<List<Integer>> result, List<Integer> path, int[] nums, int[] visited){
        
        if(path.size() == nums.length){
            result.add(new ArrayList<Integer> (path));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == 1){
                continue;
            }
            if(i != 0){
                if((nums[i] == nums[i - 1]) && visited[i-1] == 0){
                 continue;
             }
            }
             
          
            path.add(nums[i]);
            visited[i] = 1;
            helper(result, path, nums, visited);
            path.remove(path.size() - 1);
            visited[i] = 0;
            
            
        }
    }
}


