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
    int ans = 0;
    public void solve(TreeNode root, int[] freq)
    {
      if(root==null)
      {
          return;
      }
      freq[root.val]++;
      if(root.left==null && root.right==null)
      {
              int count = 0;
              for(int i=1; i<10; i++)
              {
                  if(freq[i]%2!=0) count++;
              }
              //if the number of odd numbers are less then or equal to 1
              if(count<=1)
              {
                  ans++;
              }
      }
      solve(root.left, freq);
      solve(root.right, freq);
      freq[root.val]--;
    }
    public int pseudoPalindromicPaths (TreeNode root) 
    {
        int [] freq = new int[10];
        ans=0;
        solve(root, freq);
        return ans;
    }
}