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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
     private TreeNode dummyNode = null;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        
        if(dummyNode != null){
            dummyNode.left = null;
            dummyNode.right = root;
        }
        dummyNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
        
    }
}
