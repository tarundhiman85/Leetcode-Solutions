class Solution {
    public int min(int a, int b){
        return Math.min(a,b);
    }
    public int f(int[] cost, int i, int n, Integer[] dp)
    {
     if(i>=n) return 0;
          
     if(dp[i]!=null) return dp[i];
       
     return dp[i]=cost[i] + min(f(cost, i+1, n,dp),f(cost, i+2, n,dp)); 
     
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        Integer[] dp = new Integer[n];
        return min(f(cost,0,n,dp),f(cost,1,n,dp));
   
    }
}