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
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        if(root == null){
            return Integer.MIN_VALUE;
        }
        
        
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        
        if(right < 0 && left < 0){
            return root.val;
        }
        
        if(right > left){
            return root.val + right;
        }else if(left >= right){
            return root.val + left;
        }
        
        return 0;
    }
}
