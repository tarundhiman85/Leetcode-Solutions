class Solution {
    // This function calculates the minimum effort path in a 2D grid of heights.
    public int minimumEffortPath(int[][] heights) {
                // Get the number of rows and columns in the grid.
        int rows = heights.length, cols = heights[0].length;
                // Create a 2D array to store the minimum effort required to reach each cell.
        int [][] dist = new int[rows][cols];
        // Create a priority queue to store cells ordered by their effort.
        // The priority queue will contain an array of three integers: [effort, x-coordinate, y-coordinate].
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
       // Initialize the starting cell with zero effort and add it to the priority queue.
        minHeap.add(new int[]{0, 0, 0});
       // Initialize all cells with maximum effort (infinity) except for the starting cell.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        // Define the four possible directions to move: right, left, down, and up.
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // Perform Dijkstra's algorithm to find the minimum effort path.
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int effort = top[0], x = top[1], y = top[2];
            // If the current effort is greater than the stored effort for this cell, skip it.
            if (effort > dist[x][y]) continue;
            
            // If we have reached the bottom-right cell, return the effort required to reach it.
            if (x == rows - 1 && y == cols - 1) return effort;
            // Explore all four directions from the current cell.
            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                
                // Check if the new coordinates are within the grid boundaries.
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                // Calculate the new effort required to move to the neighboring cell.
                    int new_effort = Math.max(effort, Math.abs(heights[x][y] - heights[nx][ny]));
                    
                    // If the new effort is less than the stored effort for this cell, update it.
                    if (new_effort < dist[nx][ny]) {
                        dist[nx][ny] = new_effort;
                        // Add the neighboring cell to the priority queue for further exploration.
                        minHeap.add(new int[]{new_effort, nx, ny});
                    }
                }
            }
        }
        
        // If we cannot reach the bottom-right cell, return -1.
        return -1;
    }
}