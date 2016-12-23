class element{
        int val;
        int row;
        int column;
        public element (int x, int y, int z){
            row = x;
            column = y;
            val = z;
        }
    }
    
public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    
    
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        List<Integer> result = new ArrayList<>();
        Queue<element> queue = new PriorityQueue<>(arrays.length, new Comparator<element>(){
            public int compare(element a, element b){
                return a.val - b.val;
            }
        });
        
        
        for(int i = 0; i < arrays.length; i++){
            if(arrays[i].length > 0){
                element e = new element(i, 0, arrays[i][0]);
                queue.add(e);
            }
        }
        while(!queue.isEmpty()){
            element e1 = queue.poll();
            result.add(e1.val);
            if(e1.column + 1 < arrays[e1.row].length){
                e1.column++;
                e1.val = arrays[e1.row][e1.column];
                queue.add(e1);
            }
    }
    return result;
}
}
