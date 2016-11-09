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
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> postorder = new ArrayList<Integer>();
        traverse(root,postorder);
        return postorder;
    }
    
    private void traverse(TreeNode root,ArrayList<Integer> postorder){
        if(root == null){
            return;
        }
        
        if(root.left != null){
            traverse(root.left,postorder);
        }
        if(root.right != null){
            traverse(root.right,postorder);
        }
        
        postorder.add(root.val);
        
    }
}
