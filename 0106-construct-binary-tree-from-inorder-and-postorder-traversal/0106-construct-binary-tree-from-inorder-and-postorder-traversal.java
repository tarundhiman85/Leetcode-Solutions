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
    int pI = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pI = inorder.length-1;
        return solve(inorder, postorder, 0, inorder.length-1);
    }
    public TreeNode solve(int[] inOrder, int[] postOrder, int inS, int inE)
    {
        if(pI<0 || inS>inE) return null;
        TreeNode node = new TreeNode(postOrder[pI--]);
        
        int inIndex = searchIndex(inOrder, node.val);
        node.right = solve(inOrder, postOrder, inIndex+1, inE);
        node.left = solve(inOrder, postOrder, inS, inIndex-1);
        
        return node;
    }
    public int searchIndex(int[] arr, int target)
    {
        for(int i=0; i<arr.length; i++)
        {
            if(target == arr[i])
            {
                return i;
            }
        }
        return -1;
    }
}