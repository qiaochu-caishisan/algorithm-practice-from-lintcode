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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // ListNode prev = dummy;
        ListNode curr = head;
        ListNode less = new ListNode(0);
        ListNode node3 = less;
        ListNode more = new ListNode(0);
        ListNode node4 = more;
        //将list分成两个list 一个都是小于的 一个都是大于等于的
        while(curr != null){
            if(curr.val < x){
                
                ListNode temp = curr.next;
                curr.next = node3.next;
                node3.next = curr;
                node3 = curr;
                curr = temp;
                // prev = prev.next;
            }else{
                
                ListNode temp = curr.next;
                curr.next = node4.next;
                node4.next = curr;
                node4 = curr;
                curr = temp;
                // prev = prev.next;
            }
        }
        //merge
        ListNode node1 = findlastposition(less);
        ListNode node2 = findlastposition(more);
        
        node1.next = more.next;
        return less.next;
        
    }
    private ListNode findlastposition(ListNode head){
        while(head.next != null){
            head = head.next;
        }
        return head;
    }
}
