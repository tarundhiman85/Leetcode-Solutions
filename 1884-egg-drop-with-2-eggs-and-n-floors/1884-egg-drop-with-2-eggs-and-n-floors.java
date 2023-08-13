class Solution {
static int[] dp = new int[1001]; // An array to store the computed results for each floor.

public int twoEggDrop(int n) {
    // If the result for the current floor has not been computed yet, calculate it.
    if (dp[n] == 0) {
        for (int i = 1; i <= n; ++i) {
            // Calculate the worst-case attempts needed for the current floor.
            // The expression inside Math.max represents the attempts needed if the egg breaks on the current floor.
            // The recursive part (twoEggDrop(n - i)) calculates the attempts needed for the remaining floors.
            int worstCaseAttempts = 1 + Math.max(i - 1, twoEggDrop(n - i));
            
            // Update the result for the current floor with the minimum attempts so far.
            dp[n] = Math.min(dp[n] == 0 ? n : dp[n], worstCaseAttempts);
        }
    }
    return dp[n]; // Return the calculated minimum attempts for the given floor.
}

}