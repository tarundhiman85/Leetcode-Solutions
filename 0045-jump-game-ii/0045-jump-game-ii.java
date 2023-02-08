class Solution {
    public int jump(int[] nums) {
          //GOAL is find the minimum number of jumps to reach end
        //to reach end the jumps from that index to last must be in range(n-i)
        //we initialze our dp array to MAX VALUE now we will ask the question to every index
        /*
        that index if not do jump which will be max and do jump i+jump what is minimum
        */
        int n = nums.length;
        int[] dp = new int[n+1];
        for(int i=0; i<n+1; i++){
            dp[i]=Integer.MAX_VALUE-1;
        }
        dp[n-1]=0;
        for(int i=n-2; i>-1; i--)
        {
            for(int jump = 1; jump <= nums[i] && i + jump < n; jump++){
                dp[i] = Math.min(dp[i], dp[i+jump]+1);
            }
        }
        return dp[0];
    }
}