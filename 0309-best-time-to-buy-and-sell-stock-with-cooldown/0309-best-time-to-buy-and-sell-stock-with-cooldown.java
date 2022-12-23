class Solution {
    public int solve(int ind, int buy, int[] arr, int[][] dp)
    {
        if(ind>=arr.length)
        {
            return 0;
        }
        if(dp[ind][buy]!=-1) {
            return dp[ind][buy];
        }
        if(buy==1)
        {
            //Buy Condition
            int op1 = (-arr[ind])+solve(ind+1, 0, arr, dp);
            int op2 = solve(ind+1, 1, arr, dp);
            return dp[ind][buy]=Math.max(op1, op2);
        }
        else{
            //Sell Condition
            int op1 = arr[ind]+solve(ind+2, 1, arr, dp);
            int op2 = solve(ind+1, 0, arr, dp);
            return dp[ind][buy]=Math.max(op1, op2);
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int[n][2];
        for(int i=0; i<n; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 1, prices, dp);
    }
}