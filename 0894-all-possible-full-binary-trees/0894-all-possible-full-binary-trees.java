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
    // Memoization map to store already computed results to avoid redundant calculations
    private Map<Integer, List<TreeNode>> memo = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        //If n is even it is not possible to construct full B.T
        if(n % 2 == 0) return new ArrayList<TreeNode>();
        //If n is 1, then only one possible Full B.T with a single node
        if(n == 1) return Arrays.asList(new TreeNode());
        //if the result for n is already present in memization mao
        if(memo.containsKey(n))
        {
            return memo.get(n);
        }
        // List to store the final result of all possible Full Binary Trees with n nodes.
        List<TreeNode> res = new ArrayList<TreeNode>();
        //Generate all possible combinations for the left and right subtree
        //where the left subtree has 'i' nodes and right subtree has 'n-i-1' nodes
        //we subtract 1 because one node is used as the root of the current tree
        for(int i=1; i<n; i+=2)
        {
            // Recursively compute all possible Full Binary Trees for the left subtree with 'i' nodes.
            List<TreeNode> left = allPossibleFBT(i);

            // Recursively compute all possible Full Binary Trees for the right subtree with 'n - i - 1' nodes.
            List<TreeNode> right = allPossibleFBT(n - i - 1);
            
            // Combine all possible combinations of left and right subtrees to form the current tree.
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    // Create a new root node for the current tree with value 0
                    // and attach the left and right subtrees to  it
                    TreeNode root = new TreeNode(0, l, r);
                    // Add the current tree to the final result list.
                    res.add(root);
                }
            }
        }
           // Store the computed result for 'n' in the memoization map.
        memo.put(n, res);

        // Return the list of all possible Full Binary Trees with 'n' nodes.
        return res;
    }
    
}