class Solution {
    public int backtrack(int [] nums, int mask, int pairsPicked, int[] memo)
    {
        if(2*pairsPicked == nums.length)
        {
            return 0;
        }
        if(memo[mask]!=-1)
        {
            return memo[mask];
        }
        int maxScore = 0;
        for(int i=0; i<nums.length; i++)
        {
            for(int j=i+1; j<nums.length; j++)
            {
                 // If the numbers are same, or already picked, then we move to next number.
                if(((mask>>i)&1)==1 || ((mask>>j)&1)==1)
                {
                    continue;
                }
                 // Both numbers are marked as picked in this new mask.
                int newMask = mask | (1<<i) | (1<<j);
                 // Calculate score of current pair of numbers, and the remaining array.
                int currScore = (pairsPicked + 1) * gcd(nums[i], nums[j]);
                int remainingScore = backtrack(nums, newMask, pairsPicked + 1, memo);
                //store the maximum score
                maxScore = Math.max(maxScore, currScore + remainingScore);
            }
        }
         // Store the result of the current sub-problem.
        memo[mask] = maxScore;
        return maxScore;
    }
    public int maxScore(int[] nums) {
        int memoSize = 1 << nums.length; //2^(nums array size)
        int[] memo = new int[memoSize];
        Arrays.fill(memo, -1);
        return backtrack(nums, 0, 0, memo);
    }
    public int gcd(int a, int b)
    {
        if(b==0)
        {
            return a;
        }
        return gcd(b, a%b);
    }
}