public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int m = 0; m < arrays.length; m++){
            for(int n = 0; n < arrays[m].length; n++){
                queue.add(arrays[m][n]);
            }
        }
        int count = queue.size();
        for(int i = 0; i < count; i++){
            list.add(queue.poll());
            
        }
        return list;
    }
}
