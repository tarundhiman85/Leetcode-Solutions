/**
 * This method calculates the minimum cost to transform one string (s1) into another string (s2) using two possible operations:
 * 1. Delete a character from s1.
 * 2. Delete a character from s2.
 * The goal is to find the minimum cost to perform these operations and transform s1 into s2.
 *
 * @param s1 The first string to transform.
 * @param s2 The second string to transform into.
 * @return The minimum cost to transform s1 into s2.
 */
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // Initialize the first row of the DP array.
        for (int i = 1; i <= s1.length(); i++)
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);

        // Initialize the first column of the DP array.
        for (int j = 1; j <= s2.length(); j++)
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);

        // Fill in the DP array using a bottom-up approach.
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // If the characters at the current indices (i and j) are the same, no deletion is required.
                    // So, the cost is the same as the cost for the previous characters (dp[i-1][j-1]).
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If the characters at the current indices are different, we have two options:
                    // 1. Delete the character at index i in s1 and move to the previous index (i-1).
                    // 2. Delete the character at index j in s2 and move to the previous index (j-1).
                    // We choose the option with the minimum cost.
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }

        // The final answer is in dp[s1.length()][s2.length()], which represents the minimum cost to transform s1 into s2.
        return dp[s1.length()][s2.length()];
    }
}
