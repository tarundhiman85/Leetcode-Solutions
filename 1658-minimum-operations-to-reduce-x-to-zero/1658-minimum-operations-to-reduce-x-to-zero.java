import java.util.Arrays;

public class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int prefix = nums[0];
        int sz = n;

        // Find the prefix sum
        for (int i = 1; i < n; i++) {
            if (prefix > x) {
                sz = i;
                break;
            }
            prefix += nums[i];
        }

        // If the prefix sum is less than x, it's impossible
        if (sz == n && prefix < x) {
            return -1;
        }

        prefix -= nums[sz - 1]; // Ensure prefix <= x
        int idx = sz - 1;
        int ans = Integer.MAX_VALUE;

        // If prefix itself equals x, it's a valid solution
        if (idx >= 0 && prefix == x) {
            ans = sz - 1;
        }

        int suffix = 0;

        // Iterate from the end of the array
        for (int j = n - 1; j >= 0; j--) {
            suffix += nums[j];

            // Adjust prefix to meet the condition
            while (suffix + prefix > x && prefix > 0) {
                idx--;
                prefix -= nums[idx];
                if (suffix + prefix <= x) {
                    break;
                }
            }

            // If the sum is equal to x, update the answer
            if (suffix + prefix == x) {
                ans = Math.min(ans, (n - j) + idx);
            }

            if (suffix >= x) {
                break;
            }
        }

        // If no valid solution found, return -1; otherwise, return the answer
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;
        int result = solution.minOperations(nums, x);
        System.out.println(result); // Output: 2
    }
}
