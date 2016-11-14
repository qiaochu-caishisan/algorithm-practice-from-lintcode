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
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left,right);
    }

    //merge
    private ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while((left != null) && (right != null)){
            if(left.val < right.val){
                node.next = left;
                left = left.next;
                node = node.next;
            }else{
                node.next = right;
                right = right.next;
                node = node.next;
            }
        }
            
            while(left != null){
                node.next = left;
                left = left.next;
                node = node.next;
            }
            while(right != null){
                node.next = right;
                right  = right.next;
                node = node.next;
            }
            return dummy.next;
        
    }
    //find the midle node of the list
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            if(fast == null){
                return slow;
            }
            slow = slow.next;
        }
        return slow;
    }
}
