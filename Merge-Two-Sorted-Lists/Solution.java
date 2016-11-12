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
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while(l1 != null || l2 != null){
            if(l1 == null){//因为空节点是不允许有val的
                ListNode temp = l2.next;
                l2.next = node.next;
                node.next = l2;
                l2 = temp;
                node = node.next;
            }
            else if(l2 == null){//因为空节点是不允许有val的
                ListNode temp = l1.next;
                l1.next = node.next;
                node.next = l1;
                l1 = temp;
                node = node.next;
            }else if(l1.val < l2.val){
                ListNode temp = l1.next;
                l1.next = node.next;
                node.next = l1;
                l1 = temp;
                node = node.next;
            }else{
                ListNode temp = l2.next;
                l2.next = node.next;
                node.next = l2;
                l2 = temp;
                node = node.next;
            }
        }

        return dummy.next;
    }
}
