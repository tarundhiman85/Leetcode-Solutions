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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root==null) return answer;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            while(size>0)
            {
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left!=null)
                {
                    q.offer(node.left);                
                }
                if(node.right!=null)
                {
                    q.offer(node.right);
                }
                size--;
            }
            if(temp.size()>0) answer.add(temp);
        }
        return answer;
    }
}