/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        HashSet<UndirectedGraphNode> set1 = new HashSet<>();
        
        Comparator<Integer> comparator = new Comparator<Integer>(){
            public int compare (Integer a, Integer b){
                return a - b;
            }
        };
        
        if(nodes == null){
            result.add(path);
            return result;
        }
        
        for(UndirectedGraphNode node : nodes){
            if(!set.contains(node)){
                UndirectedGraphNode head = node;
                queue.add(head);
                set.add(head);
                set1.add(head);
            while(!queue.isEmpty()){
                for(UndirectedGraphNode node1 : queue.poll().neighbors){
                    if(!set.contains(node1)){
                        set.add(node1);
                        set1.add(node1);
                        queue.add(node1);
                    }
                }
            }
            for(UndirectedGraphNode node2 : set1){
                path.add(node2.label);
            }
            Collections.sort(path, comparator);
            result.add(new ArrayList<Integer>(path));
            path.clear();
            set1.clear();
            }
            
           
        }
        return result;
        
    }
   
}
