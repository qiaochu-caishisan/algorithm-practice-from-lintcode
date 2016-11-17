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
 /*这道题的其中一种做法之一就是利用heap来解决，java里面用来实现heap的东西就是priority queue和comparator.priority queue默认是从小到大来输出，
 最小的最先被poll出去。但是这个大小的关系却是由comparator来决定的！ comparator的两个参数，参数1 和参数2 
 如果comparator的compare函数返回的是negative 那就说明参数1是小的 参数2是大的 返回的0 就说明参数1和参数2相等 返回的是正数  
 说明参数1 大一些 参数2 小一些 具体的可以去查Java手册就知道了*/
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    private Comparator<ListNode> listComparator = new Comparator<ListNode>(){
        public int compare(ListNode left, ListNode right){
            if(left == null){
                return 1;
            }
            if(right == null){
                return -1;
            }
            return left.val - right.val;
        }
    };
    public ListNode mergeKLists(List<ListNode> lists){
        if(lists.isEmpty() == true || lists.size() == 0){
            return null;
        }
        ListNode dummy = new ListNode(0);
        int k = lists.size();
        ListNode node = dummy;
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), listComparator);
            for(int i = 0; i < k; i++){
                ListNode head = new ListNode(0);
                if(lists.get(i) != null){
                    head = lists.get(i);
                    while(head != null){
                     heap.add(head);
                     head = head.next;
                    }
                }else{
                    continue;
                }
            }
            while(!heap.isEmpty()){
                node.next = heap.poll();;
                node = node.next;
            }
     
        return dummy.next;
    }
        
        
       
}
