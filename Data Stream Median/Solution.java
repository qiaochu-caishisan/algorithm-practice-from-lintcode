public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        int[] result = new int[nums.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                if(a > b){
                    return -1;
                }else if(a == b){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
        int median = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(i != 0){
                if(nums[i] > median){
                    minHeap.add(nums[i]);
                }else {
                    maxHeap.add(nums[i]);
                }
                
                while(minHeap.size() - maxHeap.size() > 1){
                    maxHeap.add(median);
                    median = minHeap.poll();
                }
                while(maxHeap.size() - minHeap.size() > 0){
                    minHeap.add(median);
                    median = maxHeap.poll();
                }
            }
            result[i] = median;
        }
        return result;
    }
}
