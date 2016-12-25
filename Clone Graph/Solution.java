/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return node;
        }
        //Step 1 BFS search all the nodes
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        ArrayList<UndirectedGraphNode> graphnodes = new ArrayList<>();
        queue.add(node);
        set.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode head = queue.poll();
            for(UndirectedGraphNode neighbor : head.neighbors){
                if(!set.contains(neighbor)){
                    queue.add(neighbor);
                    set.add(neighbor);
                }
                
            }
        }
        for(UndirectedGraphNode node1 : set){
            graphnodes.add(node1);
        }
        
        //Step 2 copy the label
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for(UndirectedGraphNode node2 : graphnodes){
            map.put(node2, new UndirectedGraphNode(node2.label));
        }
        //Step 3 copy the edges
        for(UndirectedGraphNode node3 : graphnodes){
            UndirectedGraphNode newnode = map.get(node3);
            for(UndirectedGraphNode neighbor : node3.neighbors){
                UndirectedGraphNode newneighbor = map.get(neighbor);
                newnode.neighbors.add(newneighbor);
            }
        }
        return map.get(node);
       
    }
}
