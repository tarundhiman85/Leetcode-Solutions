class Solution {
    //Goal is to find the min operations to convert s1 to s2 by using delete,replace,insert
    public static int edit(String s1, String s2)
    {
        int n = s1.length();
        int m = s2.length();
        int [][] dp = new int[n+1][m+1];
        for (int i = 0; i <=n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <=m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    //we skip the character
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                //we have 3 options 
                //insert then we dont do decrement of ith index as we are hypothetically thinking we have inserted
                int insert = 1+dp[i][j-1];
                //delete then we decrement the ith index
                int delete = 1+dp[i-1][j];
                //replace 
                int replace = 1+dp[i-1][j-1];
                dp[i][j] = Math.min(delete ,Math.min(insert, replace));
            }}
        }
        return dp[n][m];
    }
    public int minDistance(String word1, String word2) {
       return edit(word1,word2);   
    }
}