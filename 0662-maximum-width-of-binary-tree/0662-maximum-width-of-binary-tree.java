class Solution
{
  public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;      
        int maxWidth = 0;
        Queue<TreeNode> queue = new LinkedList<>(); // Queue used for BFS
        HashMap<TreeNode, Integer> map = new HashMap<>(); // Map used to keep track of indices
        queue.offer(root);
        map.put(root, 1); // Starting from index 1 
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // Getting first and last index in queue to calculate width of that level
            int start = 0; 
            int end = 0;
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                int index = map.get(node); // Getting current node's index from map
                
                // Only getting the first and the last node's index from the queue
                if (i == 0) 
                    start = index;
                if (i == levelSize - 1)
                    end = index;
                
                if (node.left != null) {
                    queue.offer(node.left);
                    map.put(node.left, index * 2);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    map.put(node.right, index * 2 + 1);
                }
            }
            
            // Calculating maximum width as we check for each level
            maxWidth = Math.max(maxWidth, end - start + 1); 
        }
        
        return maxWidth;
    }
}