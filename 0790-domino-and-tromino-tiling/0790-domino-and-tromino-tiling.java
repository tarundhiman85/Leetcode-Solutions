class Solution {
     //Memoization  
//     int MOD = 1_000_000_007;
//     int[] dp;
    
//     public int numTilings(int n) {
//         dp = new int[n+1];
//         Arrays.fill(dp, -1);
//         return helper(n);
//     }
    
//     int helper(int n) {
//         if(n < 0) return 0;
//         if(n == 0) return 1;
//         if(n <= 2) return n;
        
//         if(dp[n] != -1) return dp[n];
        
//         return dp[n] = ((2 * helper(n-1)) % MOD + (1 * helper(n-3)) % MOD) % MOD;
//     }
    //Tabulation
      private final static int mod = 1000000007;
    public int numTilings(int n) {
        
        if(n == 1) return  1;
        if(n == 2) return 2;
        
        int dp[] = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++){
            dp[i] = ((2*dp[i-1])%mod + dp[i-3])%mod;
        }
        
        return dp[n];
    }
}