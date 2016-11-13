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
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        int duplicateValue = 0;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode node = head;
        
        while(node != null && node.next != null){
            ListNode prev = dummy;
            ListNode curr = dummy.next;
            if(node.val == node.next.val){
                duplicateValue = node.val;
                while(curr != null){
                    ListNode temp = curr.next;
                    if(curr.val == duplicateValue){
                        prev.next = curr.next;
                        curr = temp;
                    }else{
                        prev = curr;
                        curr = curr.next;
                    }
                    
                }
            }
            node = node.next;
        }
        return dummy.next;
        
    }
}
