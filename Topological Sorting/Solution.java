/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
            Queue<DirectedGraphNode> queue = new LinkedList<>();
            
            HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
            ArrayList<DirectedGraphNode> result = new ArrayList<>();
            
             for(DirectedGraphNode node : graph){
                for(DirectedGraphNode neighbor : node.neighbors){
                    if(!map.containsKey(neighbor)){
                        map.put(neighbor, 1);
                    }else{
                        int count = map.get(neighbor);
                        map.put(neighbor, count + 1);
                    }
                 }
            
             }
             for(DirectedGraphNode node : graph){
                 if(!map.containsKey(node)){
                     queue.add(node);
                     result.add(node);
                 }
             }
             while(!queue.isEmpty()){
               DirectedGraphNode start = queue.poll();
               for(DirectedGraphNode node : start.neighbors){
                 if(map.get(node) == 1){
                     queue.add(node);
                     result.add(node);
                 }else{
                     map.put(node, map.get(node)-1);
                 }
                 
             }
             
             }
             
             return result;
             
                
            
    }
}
