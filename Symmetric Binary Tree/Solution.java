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
     * @param root, the root of binary tree.
     * @return true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return check(root.left, root.right);
    }
    public boolean check(TreeNode node1, TreeNode node2){
        //找到下面没有了的时候就可以返回了
        if(node1 == null && node2 == null){
            return true;
        }
        //有一个错了就是错了 所以当然是返回false的时候 返回true的时候不能保证程序继续执行 因为一直到最后一组都是对的才是对的 中间只要有一个错的都是错的
        if(node1 == null || node2 == null){
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }
        return (check(node1.left, node2.right) && check(node1.right, node2.left));
    }
}
