class Solution {
    public int f(String str, char[] s, String t, Map<String, Integer> dp, int idx)
    {
        String key= str + "_" + idx;
        if(dp.containsKey(key))
        {
            return dp.get(key);
        }
        if(str.equals(t))
        {
            dp.put(key, 1);
            return 1;
        }
        if(idx >= s.length || str.length() >= t.length())
        {
            dp.put(key, 0);
            return 0;
        }
        int res = f(str + s[idx], s, t, dp, idx + 1) + f(str, s, t, dp, idx + 1);
        dp.put(key, res);
        return res;
    }
    public int numDistinct(String s, String t) {
        // Map<String, Integer> dp = new HashMap<>();
        // return f("", s.toCharArray(), t, dp, 0);
        int sLen = s.length();
        int tLen = t.length();
        
        // Initialize a 2D DP array to store the subproblem results
        int[][] dp = new int[sLen + 1][tLen + 1];
        // Base case: If t is empty, there's one way to form an empty subsequence
        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = 1;
        }
           // Fill in the DP table using bottom-up approach
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                // If characters match, we have two options: include the current character or not
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // Characters don't match, so we can only skip the current character in s
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[sLen][tLen];
        
    }
}