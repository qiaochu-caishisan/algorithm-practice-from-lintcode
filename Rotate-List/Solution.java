/**
 * Definition for singly-linked list.
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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
       
        if(head == null || head.next == null){
            return head;
        }
         int length = findLength(head);
        k = k % length;
        if(k == 0){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode end = findEnd(head);
        
        ListNode node = end;
        if( k == 1){
            node = end;
        }else{
        while(k > 1){
            node = findNodeBefore(head, node);
            k--;
        }
        }
        ListNode turningpoint = findNodeBefore(head, node);
        turningpoint.next = null;
        end.next = head;
        dummy.next = node;
        return dummy.next;
    }
    private ListNode findEnd(ListNode head){
        while(head != null && head.next != null){
            head = head.next;
        }
        return head;
    }
    private ListNode findNodeBefore(ListNode head, ListNode node){
        if(head == null || head.next == null || head.next == node){
            return head;
        }
        while(head != null && head.next != node && head.next != null){
            head = head.next;
        }
        return head;
    }
    private int findLength(ListNode head){
        int length = 0;
        while(head != null){
            head = head.next;
            length++;
        }
        return length;
    }
}
