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
     * @param a, b, the root of binary trees.
     * @return true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        //出口
        //因为当 node是空node的时候 node.val是没有被定义的 所以不可以这样子，所以必须要列出node 为空的这三种情况，防止程序出错
        if( a == null && b == null){
            return true;
        }
        if(a == null && b != null){
            return false;
        }
        if(a != null && b == null){
            return false;
        }
        if(a.val != b.val){
            return false;
        }
        //拆解
        boolean left = isIdentical(a.left, b.left);
        boolean right = isIdentical(a.right, b.right);
        
        //定义
        return left && right;
    }
}
