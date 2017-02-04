/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0){
            return 0 ;
        }
        int depth = 1;
        int result = 0;
        ArrayList<Integer> list = new ArrayList<>();
        helper(nestedList, 1, list);
        for(Integer num : list){
            result += num;
        }
        return result;
    }
    public void helper(List<NestedInteger> nestedList, int depth, ArrayList<Integer> list){
        if(nestedList == null || nestedList.size() == 0){
            return;
        }
        for(NestedInteger element : nestedList){
            if(element.isInteger()){
                list.add(element.getInteger() * depth);
                
            }else{
                helper(element.getList(), depth + 1, list);
            }
        }
        
        
    }
   
}