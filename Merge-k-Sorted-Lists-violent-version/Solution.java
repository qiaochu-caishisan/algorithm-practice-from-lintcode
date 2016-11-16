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
    public ListNode mergeKLists(List<ListNode> lists) {  
        int k = lists.size();
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        ListNode headOfList = new ListNode(0);
        int count = Integer.MAX_VALUE;
        while(true){
            count = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < k; i++){
                ListNode compareValue = lists.get(i);
                if(compareValue == null){
                    count++;
                    continue;
                }
    
                min = Math.min(compareValue.val, min);
            }
             if(count >= k){
                    break;
                }
            for(int i = 0; i < k; i++){
                headOfList = lists.get(i);
                if(headOfList != null && headOfList.val == min){
                    ListNode newHead = headOfList.next;
                    lists.remove(i);
                    lists.add(i, newHead);
                    break;
                }else{
                    continue;
                }
            }
            node.next = headOfList;
            node = node.next;
        }
        return dummy.next;
    }
}
