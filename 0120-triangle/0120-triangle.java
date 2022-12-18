class Solution {
     public int solve(List<List<Integer>> arr, int n, int i, int j, Integer[][] dp)
    {
        if(i==n-1)
        {
            return arr.get(i).get(j);
        }
        if(j>=arr.get(i).size())
        {
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=null)
         {
          return dp[i][j];   
         }
        return dp[i][j] = arr.get(i).get(j) + Math.min(solve(arr, n, i+1, j+1, dp), solve(arr, n, i+1, j, dp));
    }
    public int minimumTotal(List<List<Integer>> arr) {
        int n = arr.size();
        Integer[][] dp = new Integer[n][n];
        return solve(arr, n, 0, 0, dp);
    }
}