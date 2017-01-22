/**
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
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        if(root == null){
            return root;
        }
        Stack<Integer> minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
        Stack<TreeNode> stack = new Stack<>();
        
        helper(root, stack, minStack);
        return stack.pop();
    }
    private int helper(TreeNode root, Stack<TreeNode> stack, Stack<Integer> minStack){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            if(root.val < minStack.peek()){
                minStack.push(root.val);
                stack.push(root);
            }
            return root.val;
        }
        
        int currentSum = root.val;
        
        int tempLeft = helper(root.left, stack, minStack);
        currentSum += tempLeft;
        
        int tempRight = helper(root.right, stack, minStack);
        currentSum += tempRight;
        
        if(currentSum < minStack.peek()){
            minStack.push(currentSum);
            stack.push(root);
        }
        return currentSum;
    }
}
