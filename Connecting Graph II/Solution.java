public class ConnectingGraph2 {
    private int[] father;
    HashMap<Integer, Integer> map;
    public ConnectingGraph2(int n) {
        // initialize your data structure here.
        father = new int[n+1];
        
        map = new HashMap<>();
        for(int i = 1; i < n+1; i++){
            map.put(i, 1);
            father[i] = i;
        }
    }

    public void connect(int a, int b) {
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b){
            father[root_b] = root_a;
            map.put(root_a, map.get(root_a) + map.get(root_b));
            
        }
    }
        
    public int query(int a) {
        // Write your code here
        int root_a = find(a);
        return map.get(root_a);
    }
    private int find(int x){
        if(father[x] == x){
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }
}
