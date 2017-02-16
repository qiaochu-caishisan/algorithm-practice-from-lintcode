public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        int[] father = new int[n];
        for(int i = 0; i < n; i++){
            father[i] = i;
        }
        
        for(int i = 0; i < edges.length; i++){
                if(find(edges[i][1], father) == find(edges[i][0], father)){
                    return false;
                }
                connect(edges[i][0], edges[i][1], father);
        }
        
        for(int i = 1; i < n; i++){
            if(find(i, father) != find(i-1, father)){
                return false;
            }
        }
        return true;
    }
    public void connect(int a, int b, int[] father){
        int root_a = find(a, father);
        int root_b = find(b, father);
        
        if(root_a != root_b){
            father[root_b] = root_a;
        }
    }
    public int find(int x, int[] father){
        if(father[x] == x){
            return x;
        }
        father[x] = find(father[x], father);
        return father[x];
    }
}
