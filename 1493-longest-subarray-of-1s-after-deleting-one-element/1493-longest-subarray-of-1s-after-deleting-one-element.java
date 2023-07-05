class Solution {
    public int longestSubarray(int[] nums) {
        int zeroCount = 0;  //Count of zeros encountered so far
        int length = 0;     //current length of subarray
        int start = 0;      //start index of current subarray
        int maxLength = 0;  //Maximum length of subarray with one zero removed
        int lastZero = -1;  //Index of the last encounterd zero, intialized to -1
        //Iterate through the input array
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == 0 && lastZero == -1)
            {
                lastZero = i;  //Encountered the first zero in the array
            }
            //the fact it updates the start with lastZero+1 if only one zero encountered if one more zero encounters then length=i-(start=lastzero+1)  which gives zero
            else if(nums[i] == 0)
            {
                start = lastZero + 1;  //update the start index of the current subarray
                lastZero = i;          //update the index of last encountered zero
            }
            length = i - start;
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}