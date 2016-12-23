class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<>();
        Queue<Long> q = new PriorityQueue<>();
        queue.add(1l);
        q.add(1l);
        for(int i = 0; i < n; i++){
            long min = q.poll();
            if(!queue.contains(min * 2l)){
                queue.add(min * 2l);
            q.add(min * 2l);
            }
            if(!queue.contains(min * 3l)){
              queue.add(min * 3l);
            q.add(min * 3l);
            }
            if(!queue.contains(min * 5l)){
              queue.add(min * 5l);
            q.add(min * 5l);
            }
            
        }
        int result = 0;
        for(int i = 0; i < n; i++){
            result = (int)(queue.poll().longValue());
        }
        return result;
    }
}
