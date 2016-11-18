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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */  
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
    private TreeNode buildTree(ListNode head){
        //chu kou
        if(head == null){
            return null;
        }
        ListNode mid = findMid(head);
        TreeNode node = new TreeNode(mid.val);
        ListNode rightStart = mid.next; 
        if(mid == head){
            head = null;
        }else{
        findNodeBefore(head, mid).next = null;
        }
       
        //chai jie
        node.left = buildTree(head);
        node.right = buildTree(rightStart);
        return node;
    }
    public TreeNode sortedListToBST(ListNode head) {  
        return buildTree(head);
    }
    private ListNode findNodeBefore(ListNode head, ListNode node){
        if(head == null){
            return null;
        }
        while(head.next != node){
            head = head.next;
        }
        return head;
    }
    
  
}
