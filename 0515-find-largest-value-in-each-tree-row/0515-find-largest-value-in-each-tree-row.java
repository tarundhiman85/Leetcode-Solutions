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
    public List<Integer> largestValues(TreeNode root) {
        //we will do level order traversal by creating a queue
        //while q is not empty we will get the first item in the queue check its left right if node is not null
        //then add the max to the list also we need something which helps us in differentiating that is null
   
        List<Integer> li = new ArrayList();
        if(root==null) return li;
        Queue<TreeNode> q = new LinkedList();
        int max = Integer.MIN_VALUE;
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            if(tmp!=null)
            {
                if(max<tmp.val)  max=tmp.val;
                if(tmp.left!=null) q.offer(tmp.left);
                if(tmp.right!=null) q.offer(tmp.right);
            }
            else{
                li.add(max);
                max=Integer.MIN_VALUE;
                if(!q.isEmpty()){
                    q.offer(null);
                }
            }
        }
        return li;
    }
}