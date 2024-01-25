class Solution {
    Integer[][] dp;
    public int lcs(char[] s1, char[] s2, int i, int j)
    {
        if(i<0 || j<0){
             return 0;
        }
        if(dp[i][j]!=null)
        {
            return dp[i][j];
        }
        if(s1[i]==s2[j])
        {
            return 1+lcs(s1, s2, i-1, j-1);
        }
        return dp[i][j] = Math.max(lcs(s1, s2, i-1, j),lcs(s1,s2,i,j-1));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new Integer[1001][1001];
        return lcs(text1.toCharArray(), text2.toCharArray(), n-1, m-1);
    }
}