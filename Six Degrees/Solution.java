/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        if(s.label == t.label){
            return 0;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        queue.add(s);

        
        HashMap<UndirectedGraphNode, Integer> map = new HashMap<>();
       
        map.put(s, 0);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode node = queue.poll();
            for(UndirectedGraphNode n : node.neighbors){
                if(map.containsKey(n)){
                    continue;
                }else{
                    map.put(n, map.get(node) + 1);
                    queue.add(n);
                    if(n == t){
                        return map.get(n);
                    }
                }
            }
        }
        return -1;
    }
}
