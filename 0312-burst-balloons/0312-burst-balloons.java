class Solution {
    public int f(int i, int j, int [] arr, Integer[][] dp)
    {
        if(i>j) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int maxi = Integer.MIN_VALUE;
        for(int ind = i; ind <= j; ind++)
        {
            int cost = arr[i-1] * arr[ind] * arr[j+1] + f(i, ind-1, arr, dp) + f(ind+1, j, arr, dp);
            maxi = Math.max(maxi, cost);
        }
        return dp[i][j] = maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int [] arr = new int[n+2];
        for(int i=1; i<=n; i++)
        {
            arr[i] = nums[i-1];
        }
        arr[0] = 1;
        arr[n+1] = 1;
        Integer[][] dp = new Integer[n+2][n+2];
        return f(1 ,n, arr, dp);
        // System.out.println(Arrays.toString(arr));
        // return 1;
    }
}