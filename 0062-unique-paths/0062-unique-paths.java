class Solution {
    //Memoization wit dp -1
    public int f(int i, int j, int m, int n, int[][] dp)
    {
        if(i>=m || j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = f(i+1,j,m,n,dp) + f(i,j+1,m,n,dp);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                dp[i][j]=0;
            }
        }
        //Tabulation
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i==0 && j==0){ 
                    dp[i][j]=1;
                    continue;
                }
                int down=0;
                int right=0;
                if(i>0) down = dp[i-1][j];
                if(j>0) right = dp[i][j-1];
                dp[i][j] = down+right;
            }
        }
        // return f(0,0,m,n,dp);
        return dp[m-1][n-1];
    }
}