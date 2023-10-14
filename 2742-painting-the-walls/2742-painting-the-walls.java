class Solution {
    int[][] memo; // A memoization array to store computed results
    int n; // The number of walls
    
    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        memo = new int[n][n + 1]; // Initialize the memoization array
        return dp(0, n, cost, time); // Call the dynamic programming function starting from the first wall
    }
    
    public int dp(int i, int remain, int[] cost, int[] time) {
        // Base case: If there are no walls left to paint, return 0 cost.
        if (remain <= 0) {
            return 0;
        }
        
        // Base case: If we've reached the last wall but there are still walls to paint, return a large value.
        if (i == n) {
            return (int) 1e9; // You can use Integer.MAX_VALUE here as well.
        }
        
        // Check if the result for this subproblem is already computed and stored in the memo array.
        if (memo[i][remain] != 0) {
            return memo[i][remain];
        }
        
        // Calculate the cost of painting the current wall and recursively explore two options:
        // 1. Paint the current wall and deduct its time from the remaining time.
        // 2. Don't paint the current wall and keep the remaining time as is.
        int paint = cost[i] + dp(i + 1, remain - 1 - time[i], cost, time);
        int dontPaint = dp(i + 1, remain, cost, time);
        
        // Store the minimum of the two options in the memo array and return it.
        memo[i][remain] = Math.min(paint, dontPaint);
        return memo[i][remain];
    }
}
