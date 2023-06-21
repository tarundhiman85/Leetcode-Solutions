class Solution {
    public long minCost(int[] nums, int[] cost) {
        // Get the length of the input arrays
        int n = nums.length;
        
        // Create a 2D array to store the pairs of (nums, cost)
        int[][] numsAndCost = new int[n][2];
        
        // Populate the numsAndCost array with the corresponding values from nums and cost arrays
        for (int i = 0; i < n; ++i) {
            numsAndCost[i][0] = nums[i];
            numsAndCost[i][1] = cost[i];
        }
        
        // Sort the numsAndCost array based on the values in the first column (nums)
        // This is done using a custom comparator using lambda expression
        Arrays.sort(numsAndCost, (a, b) -> a[0] - b[0]);

        // Calculate the prefix cost array
        long[] prefixCost = new long[n];
        prefixCost[0] = numsAndCost[0][1];
        for (int i = 1; i < n; ++i)
            prefixCost[i] = numsAndCost[i][1] + prefixCost[i - 1];
        
        // Calculate the total cost by multiplying each cost with the difference in corresponding nums values
        long totalCost = 0l;
        for (int i = 1; i < n; ++i)
            totalCost += 1l * numsAndCost[i][1] * (numsAndCost[i][0] - numsAndCost[0][0]);
        
        // Set the initial answer to the total cost
        long answer = totalCost;
        
        // Iterate over each element in the sorted numsAndCost array starting from the second element
        for (int i = 1; i < n; ++i) {
            // Calculate the gap between the current nums value and the previous one
            int gap = numsAndCost[i][0] - numsAndCost[i - 1][0];
            
            // Update the total cost by adding the cost of the elements before the current one and multiplying it by the gap
            totalCost += 1l * prefixCost[i - 1] * gap;
            
            // Subtract the cost of the elements after the current one and multiply it by the gap
            totalCost -= 1l * (prefixCost[n - 1] - prefixCost[i - 1]) * gap;
            
            // Update the answer by taking the minimum between the current answer and the updated total cost
            answer = Math.min(answer, totalCost);
        }
        
        // Return the final answer
        return answer;
    }
}
