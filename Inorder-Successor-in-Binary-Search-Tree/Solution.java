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
    boolean decide = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack =  new Stack<TreeNode>();
        // if(root == null){
        //     return null;
        // }
        while(root != null || !stack.isEmpty()){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        if(decide){
           break;
        }
         root = stack.pop();
        if(root == p){
            decide = true;
        }
        root = root.right;
         }
         if(stack.isEmpty()){
             return null;
         }
         return stack.pop();
    }
}
