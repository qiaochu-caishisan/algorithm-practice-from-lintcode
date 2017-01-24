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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        
        if(root == null){
            return result;
        }
        
        helper(result, String.valueOf(root.val), root);
        return result;
    }
    
    private void helper(List<String> result, String path, TreeNode root){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            result.add(path);
            return;
        }
        if(root.left != null){
            helper(result, path + "->" + String.valueOf(root.left.val), root.left);
        }
        if(root.right != null){
            helper(result, path + "->" + String.valueOf(root.right.val), root.right);
        }
        
    }
}
