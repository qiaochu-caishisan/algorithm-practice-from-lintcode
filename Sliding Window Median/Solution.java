public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        if(nums == null || nums.length == 0){
            return new ArrayList<Integer>();
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        if(k == 1){
            for(int i = 0; i < nums.length; i++){
                result.add(nums[i]);
            }
            return result;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1, new Comparator<Integer>(){
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
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > median){
                minHeap.add(nums[i]);
            }else{
                maxHeap.add(nums[i]);
            }
            if (i >= k) {
                if (median == nums[i - k]) {
                    if (maxHeap.size() > 0) {
                        median = maxHeap.poll();
                    } else if (minHeap.size() > 0) {
                        median = minHeap.poll();
                    } 

                } else if (median < nums[i - k]) {
                    minHeap.remove(nums[i - k]);
                } else {
                    maxHeap.remove(nums[i - k]);
                }
            }

            
            
            
            
            while(minHeap.size() - maxHeap.size() > 1){
                int temp = minHeap.poll();
                maxHeap.add(median);
                median = temp;
            }
            while(maxHeap.size() - minHeap.size() > 0){
                int temp = maxHeap.poll();
                minHeap.add(median);
                median = temp;
            }
            
            if(i >= k-1){
                result.add(median);
            }
        }
        return result;
    }
}
