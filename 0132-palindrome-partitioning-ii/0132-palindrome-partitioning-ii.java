class Solution {
    boolean isPalindrome(int i, int j, String s)
    {
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    int f(int i, int n, String s, Integer[] dp)
    {
        if(i==n) return 0;
        int mini = Integer.MAX_VALUE;
        if(dp[i]!=null) return dp[i];
        for(int j=i; j<n; j++)
        {
            if(isPalindrome(i, j, s))
            {
                int cost = 1+f(j+1, n, s, dp);
                mini = Math.min(mini, cost);
            }
        }
        return dp[i] = mini;
    }
    public int minCut(String s) {
        int n = s.length();
        // Integer[] dp = new Integer[n+1];
        // return f(0,n,s,dp)-1;
        int[] dp = new int[n+1];
        for(int i=n-1; i>=0; i--)
        {
                int mini = Integer.MAX_VALUE;
                for(int j=i; j<n; j++)
                {
                    if(isPalindrome(i, j, s))
                    {
                        int cost = 1+dp[j+1];
                        mini = Math.min(mini, cost);
                    }
                }
                dp[i] = mini;
        }
        return dp[0]-1;
    }
}