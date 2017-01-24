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
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        list.remove(root);
        for(TreeNode node : list){
            root.left = null;
            root.right = node;
            root = root.right;
        }
    }
    private void preOrder(TreeNode root, ArrayList<TreeNode> list){
        if(root == null){
            return;
        }
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
