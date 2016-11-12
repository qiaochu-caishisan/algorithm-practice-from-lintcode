/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        
        while(curr != null){
            if(curr.val == val){
                prev.next= curr.next;
                curr = curr.next;
            }else{
            prev = curr;
            curr = curr.next;
            }
        }
        return dummy.next;
    }
}
