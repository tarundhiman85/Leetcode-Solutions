class Solution {
    public int[] findErrorNums(int[] arr) {
        int n = arr.length;
        int [] freq = new int[n+1];
        for(int i=0; i<n; i++)
        {
            freq[arr[i]]++;
        }
        int [] ans = new int[2];
        for(int i=1; i<=n; i++)
        {
            if(freq[i]==2)
            {
                ans[0]=i;
            }
            if(freq[i]==0)
            {
                ans[1]=i;
            }
        }
        return ans;
    }
}