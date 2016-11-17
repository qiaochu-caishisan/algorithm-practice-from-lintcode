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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists){
        
        //出口
        if(lists.isEmpty() == true){
            return null;
        }
         int k = lists.size();
        int mid = k/2;
        if(k == 1){
            return lists.get(0);
        }
        
        
        
        ListNode dummyLeft = new ListNode(0);
        ListNode dummyRight = new ListNode(0);
        ListNode dummy = new ListNode(0);
        
        List<ListNode> leftLists = new ArrayList<>();
        List<ListNode> rightLists = new ArrayList<>();
        
       
        
        //拆解
        for(int i = 0; i < mid; i++){
            leftLists.add(lists.get(i));
        }
        for(int i = mid; i < k; i++){
            rightLists.add(lists.get(i));
        }
        
        
        dummyLeft.next = mergeKLists(leftLists);
        dummyRight.next = mergeKLists(rightLists);
        dummy.next = merge(dummyLeft.next, dummyRight.next);
        
        return dummy.next;
        
    }
    private ListNode merge(ListNode leftHead, ListNode rightHead){
        ListNode left = leftHead;
        ListNode right = rightHead;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        while(left != null && right != null){
            if(left.val < right.val){
                node.next = left;
                left = left.next;
            }else{
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }
        while(left != null){
            node.next = left;
            left = left.next;
            node = node.next;
        }
        while(right != null){
            node.next = right;
            right = right.next;
            node = node.next;
        }
        return dummy.next;
        
    }
       
}
