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
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        ArrayList<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        if(list.contains(A) && list.contains(B)){
            return helper(root, A, B);
        }
        return null;
    }
    public  void preorder(TreeNode root, ArrayList<TreeNode> list){
        if(root == null){
            return;
        }
        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }
    public TreeNode helper(TreeNode root, TreeNode A, TreeNode B){
        if(root == null || root == A || root == B){
            return root;
        }
        TreeNode left = helper(root.left, A, B);
        TreeNode right = helper(root.right, A, B);
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        if(right !=  null){
            return right;
        }
        return null;
    }
}
