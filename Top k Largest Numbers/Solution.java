class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        int[] result = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                if(a < b){
                    return 1;
                }else if(a > b){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        for(int i = 0; i < nums.length; i++){
            queue.add(nums[i]);
        }
        
        for(int i = 0; i < k; i++){
            result[i] = queue.poll();
        }
        return result;
    }

}
