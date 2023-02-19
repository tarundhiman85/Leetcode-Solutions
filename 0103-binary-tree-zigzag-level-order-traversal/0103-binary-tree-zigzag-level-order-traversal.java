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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //bfs traversal
        if(root==null)
        {
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        ans.add(temp);
        boolean flag = false;
        while(!q.isEmpty())
        {
            int size = q.size();  
            temp = new ArrayList<>();
            while(size-->0)
            {
               TreeNode r = q.remove(); 
               if(r.left!=null)
               {
                 temp.add(r.left.val);
                 q.add(r.left);
               }
               if(r.right!=null)
               {
                 temp.add(r.right.val);
                 q.add(r.right);
               }
             
            }
              if(!flag)
               {
                   Collections.reverse(temp);
               }
            flag = !flag;
            if(temp.size()>0) ans.add(temp);
        }
        return ans;
    }
}