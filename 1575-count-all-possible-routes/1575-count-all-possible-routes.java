class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        // n is the number of locations.
        int n = locations.length;

        // dp is a 2D array to store the number of routes from each location to the finish location with a given fuel.
        int dp[][] = new int[n][fuel + 1];

        // Initialize the dp array. The number of routes from the finish location to itself is 1.
        Arrays.fill(dp[finish], 1);

        // For each fuel level, from 0 to fuel,
        for (int j = 0; j <= fuel; j++) {
            // For each location,
            for (int i = 0; i < n; i++) {
                // For each other location,
                for (int k = 0; k < n; k++) {
                    // If the other location is not the current location,
                    if (k != i) {
                        // If the distance between the current location and the other location is less than or equal to the fuel level,
                        if (Math.abs(locations[i] - locations[k]) <= j) {
                            // Increment the number of routes from the current location to the finish location by the number of routes from the other location to the finish location with the remaining fuel.
                            dp[i][j] = (dp[i][j] + dp[k][j - Math.abs(locations[i] - locations[k])]) % 1000000007;
                        }
                    }
                }
            }
        }

        // Return the number of routes from the start location to the finish location with the given fuel.
        return dp[start][fuel];
    }
}