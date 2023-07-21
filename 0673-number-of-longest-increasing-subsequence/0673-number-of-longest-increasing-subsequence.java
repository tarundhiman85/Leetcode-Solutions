class Solution {
      public static int lis(int[] arr, int n)
    {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        int[] liss = new int[n];
        Arrays.fill(liss,1);
        for(int i=0; i<n; i++)
        {
            for (int j=0; j<i; j++) 
            {
                if(arr[j]<arr[i] && dp[i]<dp[j]+1)
                {
                    dp[i]=Math.max(dp[i], 1+dp[j]);
                    //inherit
                    liss[i] = liss[j];
                }
                else if(arr[j]<arr[i] && dp[i]==dp[j]+1)
                {
                    //increase the count
                    liss[i] += liss[j];
                }    
            }
            max=Math.max(max, dp[i]);
        }
        int cnt = 0;
        for (int i = 0; i < liss.length; i++) {
            if(max==dp[i])
            {
                cnt+=liss[i];
            }
        }
        return cnt;
    }
  
    public int findNumberOfLIS(int[] nums) {
        return lis(nums, nums.length);
    }
}