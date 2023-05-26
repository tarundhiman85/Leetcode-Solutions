class Solution {
     public int helper(int[] piles, int[][] dp, int[] suffixSum, int i, int M) {
         //Check if Alice has reached the end of the piles. If so, return 0 since there are no more stones to take.
        if (i == piles.length) return 0;
         //Check if Alice can take all the remaining piles. If the index plus two times M is greater than or equal to the number of piles, return the sum of stones in the remaining piles (suffixSum[i]). This is because Alice can take all the remaining piles in this case.
        if (i + 2 * M >= piles.length) return suffixSum[i];
        if (dp[i][M] != 0) return dp[i][M];
//Initialize the "result" variable to 0. This variable will store the maximum number of stones Alice can get from the current game state
        int result = 0;
//Iterate over all possible values of X, from 1 to 2 times M. X represents the number of piles Alice can take in this turn.
        for (int x = 1; x <= 2 * M; ++x) {
            //Calculate the potential [[maximum number of stones Alice can get]] if she takes [[X stones from the current position (suffixSum[i])]] and recursively calls the helper function for the next game state with the updated index and the maximum of the current M and X.
            result = Math.max(result, suffixSum[i] - helper(piles, dp, suffixSum, i + x, Math.max(M, x)));
        }

        dp[i][M] = result;
//Return the final result, representing the maximum number of stones Alice can get from the current game state.
        return result;
    }

    public int stoneGameII(int[] piles) {
        if (piles.length == 0) return 0;
        int[][] dp = new int[piles.length][piles.length];

        int[] suffixSum = new int[piles.length];
        suffixSum[suffixSum.length - 1] = piles[piles.length - 1];
        for (int i = piles.length - 2; i >= 0; --i) suffixSum[i] = piles[i] + suffixSum[i + 1];

        return helper(piles, dp, suffixSum, 0, 1);
    }
}