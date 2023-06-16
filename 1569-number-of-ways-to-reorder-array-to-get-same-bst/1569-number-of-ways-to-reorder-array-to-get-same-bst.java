class Solution {
    private static final int MOD = 1000000007;
    
    public int numOfWays(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        // Store the numbers from the input array into a list
        for (int num : nums) {
            list.add(num);
        }
        
        // Calculate the number of ways to arrange the binary tree and subtract 1
        return countWays(list) - 1;
    }
    
    // Recursive helper method to count the number of ways to arrange the binary tree
    private int countWays(List<Integer> nums) {
        if (nums.size() <= 2) {
            return 1; // Only one way to arrange a tree with 0 or 1 node
        }
        
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int root = nums.get(0); // The first element is the root of the tree
        
        // Partition the remaining numbers into left and right subtrees
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }
        
        // Recursively calculate the number of ways for the left and right subtrees
        long leftCount = countWays(left);
        long rightCount = countWays(right);
        
        // Calculate the binomial coefficient and multiply the counts of left and right subtrees
        return (int) ((comb(nums.size() - 1, left.size()) % MOD) * (leftCount % MOD) % MOD * (rightCount % MOD) % MOD);
    }
    
    // Method to calculate the binomial coefficient using dynamic programming
    private long comb(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        
        return dp[n][k];
    }
}
