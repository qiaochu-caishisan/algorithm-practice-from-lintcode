/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MIN_VALUE);
        helper(root, stack);
        return stack.pop();
    }
    private int helper(TreeNode root, Stack<Integer> stack){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int pathLeft = 1;
        int pathRight = 1;
        int tempLeft = helper(root.left, stack);
        if(root.left != null){
            if(root.left.val - root.val == 1){
                pathLeft += tempLeft;
            }
        }
        
        int tempRight = helper(root.right, stack);
        if(root.right != null){
           if(root.right.val - root.val == 1){
                pathRight += tempRight;
            } 
        }
        
        int path = (pathLeft > pathRight)?pathLeft : pathRight;
        if(path > stack.peek()){
            stack.push(path);
        }
        return path;
    }
}
