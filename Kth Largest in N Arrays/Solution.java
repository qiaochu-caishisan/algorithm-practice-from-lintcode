public class Solution {
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(arrays.length, new Comparator<Integer>(){
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
            
            for(int i = 0; i < arrays.length; i++){
                for(int j = 0; j < arrays[i].length; j++){
                    queue.add(arrays[i][j]);
                }
            }
            
            for(int i = 0; i < k-1; i++){
                queue.poll();
            }
            int result = queue.poll();
            return result;
    }
}
