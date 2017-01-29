/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        Stack<UndirectedGraphNode> stack = new Stack<>();
        
        queue.offer(node);
        set.add(node);
        stack.push(node);
        int min = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()){
            UndirectedGraphNode tempnode = queue.poll();
            for(UndirectedGraphNode neighbor : tempnode.neighbors){
                if(!set.contains(neighbor)){
                    set.add(neighbor);
                    queue.offer(neighbor);
                    if(values.get(neighbor) == target){
                        return neighbor;
                    }
                    if(Math.abs(values.get(neighbor) - target) < min){
                        min = Math.abs(values.get(neighbor) - target);
                        stack.push(neighbor);
                    }
                }
            }
        }
        return stack.pop();
    }
}
