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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start;
        //当m = 1的时候，findnposion 这个函数不能正常输出，所以我们把这种情况专门说一下
        if(m == 1){
             start = dummy;
        }else{
             start = findnposition(head, m-1);
        }
        ListNode end = findnposition(head, n+1);
        ListNode prev = start.next;
        ListNode curr = start.next.next;
        while(curr != end){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        start.next.next = curr;
        start.next = prev;
        return dummy.next;
    }
    
    private ListNode findnposition(ListNode head, int m){
        int count = m;
        while(m != 1 && head != null){
            head = head.next;
            m--;
        }
        return head;
    }
}
