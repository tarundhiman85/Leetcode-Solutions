class Solution {
    public int f(int[] pile, int i, int j, int[][] dp)
    {
        if(i>j)
        {
            return 0;
        }
        if(dp[i][j]!=0)
        {
            return dp[i][j];
        }
        return dp[i][j] = Math.max(pile[i] - f(pile, i+1, j, dp), pile[j] - f(pile, i, j-1, dp));
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        int res = f(piles, 0, n-1, dp);
        if(res >0)
        {
            // System.out.println(res);
            return true;
        }
        return false;
    }
}