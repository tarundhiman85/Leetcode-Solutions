class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxElement = Arrays.stream(nums).max().getAsInt();
        
        long subArrayCount = 0;
        int maxCount = 0;
        int start = 0;
        
        for(int end=0; end<n; end++)
        {
            if(nums[end] == maxElement)
            {
                maxCount++;
            }
            while(k == maxCount)
            {
                if(nums[start] == maxElement)
                {
                    maxCount--;
                }
                start++;
            }
            subArrayCount += start;
        }
        return subArrayCount;
    }
}