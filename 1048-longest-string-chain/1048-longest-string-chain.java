class Solution {
        public boolean isComp(char[] a, char[] b)
    {
        if(a.length!=b.length+1) return false;
        int first = 0;
        int second = 0;
        while(first<a.length)
        {
            if(second<b.length && a[first]==b[second])
            {
                first++;
                second++;
            }
            else first++;
        }
        return first==a.length && second==b.length;
    }
    public int longestStrChain(String[] words)
    {
        int n = words.length;
        if(n==1) return 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp,1);
        int max_len = 0;
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String a, String b)
            {
                return a.length()-b.length();
            }
        });
        for(int i=1;i<n;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(isComp(words[i].toCharArray(), words[j].toCharArray()))
                {
                    if(dp[i]<1+dp[j])
                    {
                        dp[i]=1+dp[j];
                    }
                }
            }
            if(max_len<dp[i])
            {
                max_len = dp[i];
            }
        }
        return max_len;
    }
}