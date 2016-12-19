/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
         if (head == null) {
            return null;
        }

        RandomListNode dummy = new RandomListNode(0);
        RandomListNode node;
        RandomListNode prev = dummy;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while(head != null){
            if(map.containsKey(head)){
                node = map.get(head);
            }
            else{
                node = new RandomListNode(head.label);
                map.put(head, node);
            }
            
            prev.next = node;
            
            if(head.random != null){
                if(map.containsKey(head.random)){
                    node.random = map.get(head.random);
                }
                else{
                    node.random = new RandomListNode(head.random.label);
                    map.put(head.random, node.random);
                }
                
            }
            prev = node;
            head = head.next;
            
        }
        return dummy.next;
    }
}
