class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][3];
        //                         buy/sell Cap
        for(int ind = n-1; ind>=0; ind--)
        {
            for(int buy = 0; buy<2; buy++)
            {
                 int profit = 0;
                 if(buy==1)
                 {
                                            //buying the stock                //skip with buy 1 needs to buy
                     dp[ind][buy] = Math.max(-prices[ind]-fee+dp[ind+1][0],  dp[ind+1][1]);
                 }
                 else{                      //selling the stock                //skip with buy 0 nneds to sell
                     dp[ind][buy] = Math.max(prices[ind]+dp[ind+1][1], dp[ind+1][0]);
                 }
            }
        }
        return dp[0][1];  
    }
}