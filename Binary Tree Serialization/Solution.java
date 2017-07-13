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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        String result = null;
        StringBuilder sb = new StringBuilder ();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
               sb.append(node.val);
               sb.append(',');
               queue.add(node.left);
               queue.add(node.right);
            }else{
                sb.append('#');
                sb.append(',');
            }
        }
        result = sb.toString();
        return result;
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        String[] number = data.split(",");
        TreeNode root = null;
        if(number[0].equals("#")){
            return root;
        }else{
            root = new TreeNode(Integer.parseInt(number[0]));
        }
        boolean isLeft = true;
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        int i = 1;
        int index = 0;
        while(i < number.length){
            TreeNode node = list.get(index);
            if(number[i].equals("#")){
                if(isLeft){
                    node.left = null;
                }else{
                    node.right = null;
                }
            }else{
                if(isLeft){
                    node.left = new TreeNode(Integer.parseInt(number[i]));
                    list.add(node.left);
                }else{
                    node.right = new TreeNode(Integer.parseInt(number[i]));
                    list.add(node.right);
                }
            }
            if(!isLeft){
                index ++;
            }
            isLeft = !isLeft;
            i++;
        }
        return root;
    }
}
