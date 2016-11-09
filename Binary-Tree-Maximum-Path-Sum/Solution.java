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
     * @return: An integer.
     */
     private class ResultType{
         int singlepath;
         int maxpath;
         ResultType(int singlepath, int maxpath){
             this.singlepath = singlepath;
             this.maxpath = maxpath;
         }
     }
     
     
     public ResultType helper(TreeNode root){
         if(root == null){
             return new ResultType(0, Integer.MIN_VALUE);
         }
         
         ResultType left = helper(root.left);
         ResultType right =  helper(root.right);
         
         int singlepath = Math.max(left.singlepath, right.singlepath) + root.val;
         singlepath = Math.max(singlepath, 0);
         
         int maxpath = Math.max(left.maxpath, right.maxpath);
         maxpath = Math.max(maxpath, left.singlepath + right.singlepath + root.val);
         
         return new ResultType(singlepath, maxpath);
         
     }
     
     
     
    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxpath;
    }
}
