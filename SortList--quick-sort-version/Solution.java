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
     //quick sort
     public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMid(head);
        ListNode leftDummy = new ListNode(0);
        ListNode leftTail = leftDummy;
        ListNode rightDummy = new ListNode(0);
        ListNode rightTail = rightDummy;
        ListNode middleDummy = new ListNode(0);
        ListNode middleTail = middleDummy;
        while(head != null){
            if(head.val < mid.val){
                leftTail.next = head;
                leftTail = head;
            }else if(head.val > mid.val){
                rightTail.next = head;
                rightTail = head;
            }else{
                middleTail.next = head;
                middleTail = head;
            }
            head = head.next;
        }
        leftTail.next = null;
        rightTail.next = null;
        middleTail.next = null;
        
        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);
        
        return concat(left, middleDummy.next, right);
     }
     private ListNode concat(ListNode left, ListNode middle, ListNode right){
         ListNode dummy = new ListNode(0);
         ListNode tail = dummy;
         tail.next =left; 
         tail = findEnd(tail);
         tail.next = middle;
         tail = findEnd(tail);
         tail.next = right;
         tail = findEnd(tail);
         return dummy.next;
     }
     private ListNode findEnd(ListNode head){
         if(head == null){
             return null;
         }
         while(head.next != null){
             head = head.next;
         }
         return head;
     }
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
