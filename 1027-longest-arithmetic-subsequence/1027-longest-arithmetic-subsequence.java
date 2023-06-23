
class Solution {
   public int longestArithSeqLength(int[] nums) {
    int n = nums.length;
    int longest = 0;
    Map<Integer, Integer>[] dp = new HashMap[n];

    for (int i = 0; i < n; i++) {
        dp[i] = new HashMap<>();

        for (int j = 0; j < i; j++) {
            int diff = nums[i] - nums[j];
            // Get the length of the arithmetic subsequence ending at index 'j' with difference 'diff'
            int length = dp[j].getOrDefault(diff, 1) + 1;
            dp[i].put(diff, length); // Store the length of the arithmetic subsequence ending at index 'i' with difference 'diff'
            longest = Math.max(longest, length); // Update the longest length so far
        }
    }

    return longest;
}
}

/*
  if arr[i]-arr[i-1] == diff
     choice1= 1+compute(arr, diff)
   else 
     choice2= compute(arr, arr[i]-arr[i-1])
   return max(choice1, choice2)  
*/