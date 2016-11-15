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
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {
        
        ListNode end = findEnd(head);
        ListNode node  = head;
        ListNode mid = findMid(head);
        while(node != mid){
            ListNode prev = findNodeBefore(head, end);
            prev.next = end.next;
            end.next = node.next;
            node.next = end;
            node = node.next.next;
            end = prev;
        }
        // end.next = node.next.next;
        // node.next = end;
        
    }
    private ListNode findEnd(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        while(head.next != null){
            head = head.next;
        }
        return head;
    }
    private ListNode findNodeBefore(ListNode head, ListNode node){
        while(head.next != node){
            head = head.next;
        }
        return head;
    }
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast =fast.next.next;
             if(fast == null){
                return slow;
             }
             slow = slow.next;
        }
        return slow;
    }
}
