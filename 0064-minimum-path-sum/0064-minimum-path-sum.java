class Solution {
     //Memoization wit dp -1
    public int f(int i, int j, int m, int n, int[][] grid, int[][] dp)
    {
        if(i>=m || j>=n) return Integer.MAX_VALUE;
        if(i==m-1 && j==n-1)
        {
           return grid[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
       return dp[i][j] = grid[i][j] + Math.min(f(i+1, j, m, n,  grid,  dp), f(i, j+1, m, n,  grid,  dp));
     
    }
    public int uniquePaths(int m, int n, int [][] grid) {
        int[][] dp = new int[m][n];
         //Tabulation
         for(int i=0; i<m; i++)
         {
             for(int j=0; j<n; j++)
             {
                 if(i==0 && j==0){
                     dp[i][j]=grid[i][j];
                     continue;
                 }
                 int up = Integer.MAX_VALUE;
                 int down = Integer.MAX_VALUE;
                 if(i>0) up = dp[i-1][j];
                 if(j>0) down = dp[i][j-1];
                 dp[i][j] = grid[i][j] + Math.min(up, down);
             }
         }
        return dp[m-1][n-1];
    }
    public int minPathSum(int[][] grid) 
    {
        return uniquePaths(grid.length, grid[0].length, grid);
    }
}