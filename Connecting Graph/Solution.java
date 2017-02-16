public class ConnectingGraph { 
    int[] father;
    public ConnectingGraph(int n) {
        // initialize your data structure here.
       father = new int[n+1];
       for(int i = 1; i <= n; i++){
           father[i] = i;
       }
    }

    public void connect(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b){
            father[root_b] = root_a;
        }
    }
        
    public boolean  query(int a, int b) {
        if(find(a) == find(b)){
            return true;
        }
        return false;
    }
    public int find(int x){
        if(father[x] == x){
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }
}
