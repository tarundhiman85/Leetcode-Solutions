class Solution {
    int f(int[] arr, int i, Integer[] dp, int k)
    {
        int n = arr.length;
        if(i>=n) return 0;
        if(dp[i]!=null) return dp[i];
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        int len = 0;
        for(int j=i; j<Math.min(i+k, n); j++)
        {
            len++;
            maxi = Math.max(arr[j], maxi);
            sum = (len * maxi) + f(arr, j+1, dp, k);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[i] = maxAns;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        // Integer[] dp = new Integer[n+2];
        // return f(arr, 0, dp, k);
        int[] dp = new int[n+2];
        for(int i=n-1; i>=0; i--)
        {
            int sum = 0;
            int maxi = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;
            int len = 0;
            for(int j=i; j<Math.min(i+k, n); j++)
            {
                len++;
                maxi = Math.max(arr[j], maxi);
                sum = (len * maxi) + dp[j+1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[i] = maxAns;
        }
        return dp[0];
    }
}