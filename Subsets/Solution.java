class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        result.add(path);
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        helper(result, path, nums, 0);
        return result;
    }
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, int[] nums, int index){
        for(int i = index; i < nums.length; i++){
            if(path.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            result.add(new ArrayList<Integer>(path));
            helper(result, path, nums, i);
            path.remove(path.size() - 1);
        }
    }
}
