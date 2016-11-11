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
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        if(root == null){
            return result;
        }
        level.add(root.val);
        helper(root, target, result, level, root.val);
        return result;
        
        
    }
    
    private void helper(TreeNode root, int target, List<List<Integer>> result, List<Integer> level, int sum){
        if(root.left == null && root.right == null){
            if(sum == target){
            result.add(new ArrayList<Integer> (level));
            }
            return;
        }
        
        if(root.left != null){
            
            level.add(root.left.val);
            helper(root.left, target, result, level, sum + root.left.val);
            level.remove(level.size() - 1);
        }
        if(root.right != null){
            level.add(root.right.val);
            helper(root.right, target, result, level, sum + root.right.val);
            level.remove(level.size() - 1);
        }
        
        
    }
}
