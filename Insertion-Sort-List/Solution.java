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
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        
        while(head != null){
            ListNode node = dummy;
            while(node.next != null && head.val > node.next.val){
                node = node.next;
            }
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
            //注意这一段不可以写成：ListNode temp = head;
            // head.next = node.next;
            // node.next = head;
            // head = temp.next
            //因为使用temp的原因就是因为head.next 的值被改变了，而将temp 赋了head的值，head.next 改变 temp.next也跟着head改变了 等于没使用temp
        }
        return dummy.next;
    }
}
