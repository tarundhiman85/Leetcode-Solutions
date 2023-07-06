class Solution {
    public int minSubArrayLen(int target, int[] nums) {
         int left = 0;
         int right = 0;
         int sumOfCurrentWindow = 0;
         int res = Integer.MAX_VALUE;
        for(right = 0; right< nums.length; right++)
        {
            sumOfCurrentWindow += nums[right];
            
            while(sumOfCurrentWindow >= target)
            {
                res = Math.min(res, right-left + 1);
                sumOfCurrentWindow -= nums[left];
                left++;
            }
            
        }
        return res == Integer.MAX_VALUE? 0 : res;
    }
}