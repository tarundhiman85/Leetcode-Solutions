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
        //Tabulation
//         for(int i=0;i<n;i++)
//         {
//             Arrays.fill(dp[i], Integer.MAX_VALUE);
//         }
//       int minV = Integer.MAX_VALUE;
//         for(int i=0; i<n; i++)
//         {
//             for(int j=0; j<arr.get(i).size(); j++)
//             {

//                 if(i==0 && j==0)
//                 {
//                     dp[i][j] = arr.get(i).get(j);
//                     if(i==n-1) minV = Math.min(minV, dp[i][j]);
//                 }
//                 else{
//                     int dr = Integer.MAX_VALUE;
//                     int d = Integer.MAX_VALUE;
//                     if(i>0 && j>0) dr = dp[i-1][j-1];
//                     if(i>0) d = dp[i-1][j];
//                     dp[i][j] = arr.get(i).get(j) + Math.min(dr, d);
//                     if(i==n-1) minV = Math.min(minV, dp[i][j]);
//                 }
//             }
//         }
//         return minV;
    }
}