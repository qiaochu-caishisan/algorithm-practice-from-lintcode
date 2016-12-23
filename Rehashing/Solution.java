/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        int capacity = hashTable.length;
        int newcapacity = 2 * capacity;
        ListNode[] newhashTable = new ListNode[newcapacity];
        
        for(int i = 0; i < capacity; i++){
            while(hashTable[i] != null){
                int hashcode = (hashTable[i].val % newcapacity + newcapacity) % newcapacity;
                if(newhashTable[hashcode] == null){
                    newhashTable[hashcode] = new ListNode(hashTable[i].val);
                }else{
                    ListNode node = newhashTable[hashcode];
                    while(node.next != null){
                        node = node.next;
                    }
                    node.next = new ListNode(hashTable[i].val);
                    
                }
                hashTable[i] = hashTable[i].next;

            }
        }
        return newhashTable;
    }
}
