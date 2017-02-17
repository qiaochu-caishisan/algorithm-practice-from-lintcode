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
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        HashSet<DirectedGraphNode> set = new HashSet<>();
        HashSet<DirectedGraphNode> head = new HashSet<>();
        HashMap<DirectedGraphNode, DirectedGraphNode> father = new HashMap<>();
        HashMap<DirectedGraphNode, List<Integer>> map = new HashMap<>();
        for(DirectedGraphNode node : nodes){
            father.put(node, node);
        }
        
        for(DirectedGraphNode node : nodes){
            for(DirectedGraphNode neighbor : node.neighbors){
                if(find(neighbor, father)  != find(node, father)){
                    connect(node, neighbor, father);
                }
            }
        }
        
        for(DirectedGraphNode node : nodes){
            
            DirectedGraphNode temp = find(node, father);
            
            if(!map.containsKey(temp)){
                map.put(temp, new ArrayList<Integer>());
                map.get(temp).add(node.label);
            }else{
                map.get(temp).add(node.label);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(DirectedGraphNode node : map.keySet()){
            
            List<Integer> list = map.get(node);
            Collections.sort(list, new Comparator<Integer>(){
                public int compare(Integer a, Integer b){
                    if(a > b){
                        return 1;
                    }else if(a < b){
                        return -1;
                    }else {
                        return 0;
                    }
                }
            });
            result.add(list);
            
        }
        
        return result;
    }
    public void connect(DirectedGraphNode a, DirectedGraphNode b, HashMap<DirectedGraphNode, DirectedGraphNode> father){
        DirectedGraphNode root_a = find(a, father);
        DirectedGraphNode root_b = find(b, father);
        
        if(root_a != root_b){
            father.put(root_b, root_a);
        }
    }
    
    public DirectedGraphNode find(DirectedGraphNode x, HashMap<DirectedGraphNode, DirectedGraphNode> father){
         DirectedGraphNode parent =  father.get(x);
            while(parent!=father.get(parent)) {
                parent = father.get(parent);
            }
            return parent;
    }
}
