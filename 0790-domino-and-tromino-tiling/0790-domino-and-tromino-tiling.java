class Solution {
       
    int MOD = 1_000_000_007;
    int[] dp;
    
    public int numTilings(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n);
    }
    
    int helper(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(n <= 2) return n;
        
        if(dp[n] != -1) return dp[n];
        
        return dp[n] = ((2 * helper(n-1)) % MOD + (1 * helper(n-3)) % MOD) % MOD;
    }
}