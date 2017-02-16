public class ConnectingGraph3 {
    private int count;
    int[] father;
   
    public ConnectingGraph3(int n) {
        // initialize your data structure here.
        
        father = new int[n+1];
        count = n;
        for(int i = 1; i < n+1; i++){
            father[i] = i;
        }
    }

    public void connect(int a, int b) {
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b){
            father[root_b] = root_a;
            count--;
        }
    }
        
    public int query() {
        // Write your code here
        return count;
    }
    
    public int find(int x){
        if(father[x] == x){
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }
}
