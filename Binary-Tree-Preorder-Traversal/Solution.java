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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> preorder =  new ArrayList();
        
        Tranverse(root,preorder);
        return preorder;
    }
        
        private void Tranverse(TreeNode root, ArrayList<Integer> preorder){
            if(root == null){
                return;
            }
            
            preorder.add(root.val);
            Tranverse(root.left,preorder);
            Tranverse(root.right,preorder);
        }
    }
