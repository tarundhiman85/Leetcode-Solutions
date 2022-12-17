class Solution {
    public int uniquePathsWithObstacles(int[][] grid){
        int n = grid[0].length;
        int m = grid.length;
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i==0 && j==0 && grid[i][j]!=1){
                    dp[i][j]=1;
                    continue;
                }
                if(grid[i][j]==1) 
                {
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