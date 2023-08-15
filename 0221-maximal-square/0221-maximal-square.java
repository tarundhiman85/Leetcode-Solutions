class Solution {
    public int maximalSquare(char[][] matrix) {
        // Call the utility function and return its result
        return util1(matrix);
    }

    public int util1(char[][] matrix) {
        // Create a dynamic programming array to store the side lengths of maximal squares
        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans = 0; // Initialize the maximum area variable

        // Populate the first row of the dp array
        for (int i = 0; i < dp.length; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1; // Initialize side length to 1 if '1' is present
                ans = 1; // Update the maximum area if necessary
            }
        }

        // Populate the first column of the dp array
        for (int j = 0; j < dp[0].length; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1; // Initialize side length to 1 if '1' is present
                ans = 1; // Update the maximum area if necessary
            }
        }

        // Iterate through the dp array to compute maximal square side lengths
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i][j] == '1') {
                    // Calculate the side length of the maximal square ending at (i, j)
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    // Update the maximum area if the new square's side length is larger
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }

        // Return the maximum area by squaring the side length
        return ans * ans;
    }
}
