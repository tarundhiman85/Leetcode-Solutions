class Solution {
    public String longestPalindrome(String s) {
       char[] c = s.toCharArray();
       int n = c.length;
        String ans="";
       boolean [][] dp = new boolean[n][n];
       for(int gap=0; gap<n; gap++)
       {
           for(int i=0, j=gap; j<n; i++, j++)
           {
               if(gap==0) 
               {
                   dp[i][j]=true;
               }
               else if(gap==1)
               {
                   if(c[i]==c[j]) dp[i][j]=true;
                   else dp[i][j]=false;
               }
               else{
                   if(c[i]==c[j] && dp[i+1][j-1])
                   {
                       dp[i][j] = true;
                   }
                   else{
                       dp[i][j]=false;
                   }
               }
               if(dp[i][j])
               {
                   ans=s.substring(i,j+1);
                   // System.out.println(i+" "+j);
               }
           } 
       }
        return ans;
    }
}