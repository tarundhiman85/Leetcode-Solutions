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
    int min = Integer.MAX_VALUE;
    public void minD(TreeNode root, int lvl){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            min=Math.min(lvl,min);
        }
        minD(root.left,lvl+1);
        minD(root.right,lvl+1);
    }
    public int minDepth(TreeNode root) {
        minD(root,1);
        return min==2147483647?0:min;
    }
}