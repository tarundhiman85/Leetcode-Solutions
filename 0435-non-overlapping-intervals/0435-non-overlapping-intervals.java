class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort the intervals based on their end points in ascending order
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int ans = 0; // Initialize the answer variable to keep track of overlapping intervals
        int k = Integer.MIN_VALUE; // Initialize k to the smallest possible value
        
        // Iterate through the intervals
        for (int i = 0; i < intervals.length; i++) {
            int x = intervals[i][0]; // Start point of the current interval
            int y = intervals[i][1]; // End point of the current interval
            System.out.println(x+"-"+y);
            if (x >= k) {
                // Case 1: If the start point of the current interval is greater than or equal to k,
                // update k to the end point of the current interval and continue
                k = y;
            } else {
                // Case 2: If the start point of the current interval is less than k,
                // it means there is an overlap with the previous interval.
                // Increment the answer variable and move on to the next interval
                ans++;
            }
        }
        
        // Return the total number of overlapping intervals
        return ans;
    }
}
