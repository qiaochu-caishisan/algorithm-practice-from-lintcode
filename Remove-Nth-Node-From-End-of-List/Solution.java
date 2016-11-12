/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode curr = head;
        
        
        while(curr != null){
            ListNode node = curr;
            int i = n;
            while( i > 0){
                node = node.next;
                i--;
            }
            if(node == null){
                prev.next = curr.next;
                break;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
        
    }
}
