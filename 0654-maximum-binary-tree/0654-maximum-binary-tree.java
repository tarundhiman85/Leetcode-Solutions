/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> st = new Stack<>();
        for(int num : nums){
            TreeNode node = new TreeNode(num);
            while(!st.isEmpty() && num > st.peek().val){
                node.left = st.pop();
            }
            if(!st.isEmpty()){
                st.peek().right = node;
            }
            st.push(node);
        }
        return st.get(0);
    }
}