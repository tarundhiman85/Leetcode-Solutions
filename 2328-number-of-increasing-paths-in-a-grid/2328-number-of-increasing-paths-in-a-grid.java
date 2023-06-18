class Solution {
    int[][] dp; // 2D array to store previously computed results
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // Directions to explore neighboring cells
    int mod = 1_000_000_007; // Modulo value used for computation
    
    // Recursive function to calculate the number of paths starting from cell (i, j)
    int dfs(int[][] grid, int i, int j) {
        // If dp[i][j] is non-zero, it means we have already computed the value for dfs(i, j),
        // so we can just return dp[i][j] as the result.
        if (dp[i][j] != 0)
            return dp[i][j];

        // Otherwise, set answer = 1, representing the path made of grid[i][j] itself.
        int answer = 1;

        // Check the four neighboring cells and move to a cell with a smaller value if possible.
        for (int[] d : directions) {
            int prevI = i + d[0], prevJ = j + d[1];
            if (0 <= prevI && prevI < grid.length && 0 <= prevJ && 
                prevJ < grid[0].length && grid[prevI][prevJ] < grid[i][j]) {
                answer += dfs(grid, prevI, prevJ); // Recursively solve the subproblem: dfs(prevI, prevJ)
                answer %= mod; // Take modulo to prevent overflow
            }
        }

        // Update dp[i][j] with the computed answer, so that we don't recalculate it later.
        dp[i][j] = answer;
        return answer;
    }
    
    // Function to count all possible paths starting from any cell in the grid
    public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp = new int[m][n]; // Initialize dp array with zeros

        // Iterate over all cells grid[i][j] and sum up the results from dfs(i, j).
        int answer = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                answer = (answer + dfs(grid, i, j)) % mod; // Add the result of dfs(i, j) to the answer
            }
        }

        return answer; // Return the total number of paths
    }
}
