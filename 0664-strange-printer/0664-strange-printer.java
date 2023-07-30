class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int [][] dp = new int[n][n];
        
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, 1));
        
        for(int i=n-1; i>=0; i--)
        {
            for(int d=1; d<n-i; d++)
            {
                int j = d + i;
                if(d==1)
                {
                    dp[i][j] = s.charAt(i)==s.charAt(j)?1:2;
                    continue;
                }
                dp[i][j] = 1001;
                for(int k=i; k<j; k++)
                {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j]);
                }
                if(s.charAt(i)==s.charAt(j))
                {
                    dp[i][j]--;
                }
            }
        }
        return dp[0][n-1];
    }
}