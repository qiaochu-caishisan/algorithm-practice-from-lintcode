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
            int temp = Integer.MIN_VALUE;
             boolean result = true;
             boolean firstnode = true;
            
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return traverse(root);
    }
    
    private boolean traverse(TreeNode root){
        
        if(root == null){
            return true;
        }
        
        if(root.left != null){
            traverse(root.left);
        }
         if(root.val <= temp && !firstnode){
             result = false;
         }
         firstnode = false;
        temp = root.val;
        if(root.right != null){
            traverse(root.right);
        }
        
        return result;
        
    }
}
