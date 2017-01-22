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
class node{
    int sum;
    int count;
    public node(int a, int b){
        sum = a;
        count = b;
    }
}
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Double> maximumStack = new Stack<>();
        maximumStack.push(Double.MIN_VALUE);
        helper(root, stack, maximumStack);
        TreeNode result = stack.pop();
        return result;
    }
    private node helper(TreeNode root, Stack<TreeNode> stack, Stack<Double> maximumStack){
        if(root == null){
            return new node(0, 0);
        }
        if(root.left == null && root.right == null){
            if(root.val > maximumStack.peek()){
                maximumStack.push((double)root.val);
                stack.push(root);
            }
            return new node(root.val, 1);
        }
        
        int currentSum = root.val;
        int currentCount = 1;
        
        node left = helper(root.left, stack, maximumStack);
        currentSum += left.sum;
        currentCount += left.count;
        
        node right = helper(root.right, stack, maximumStack);
        currentSum += right.sum;
        currentCount += right.count;
        
        double average = (double)currentSum / currentCount;
        if(average > maximumStack.peek()){
            maximumStack.push(average);
            stack.push(root);
        }
        
        return new node(currentSum, currentCount);
    }
}
