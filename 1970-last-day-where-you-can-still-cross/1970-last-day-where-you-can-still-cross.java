class Solution {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    // The 'directions' array represents the four possible directions: down, up, right, left.
    // Each direction is represented as a pair of integers: {row_increment, col_increment}.
    // For example, {1, 0} represents moving down (incrementing the row index) and not changing the column index.

    public boolean canCross(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];  // Create a grid with the given row and column dimensions.
        Queue<int[]> queue = new LinkedList<>();  // Create a queue to store the cells to be explored.

        // Initialize the grid based on the cells available up to the given day.
        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        // Start from the top row (row 0) and add all reachable cells to the queue.
        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 0) {
                queue.offer(new int[]{0, i});  // Add the cell coordinates (row, col) to the queue.
                grid[0][i] = -1;  // Mark the cell as visited by setting its value to -1.
            }
        }

        // Perform a breadth-first search to find a path from the top row to the bottom row.
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();  // Get the next cell to explore from the queue.
            int r = cur[0], c = cur[1];  // Extract the row and column indices.

            if (r == row - 1) {
                // If the current cell is in the bottom row, we have found a path.
                // Return true to indicate that it is possible to cross the grid.
                return true;
            }

            // Explore the neighboring cells in all four directions.
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                // Check if the new cell is within the grid boundaries and is not visited.
                if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && grid[newRow][newCol] == 0) {
                    grid[newRow][newCol] = -1;  // Mark the new cell as visited.
                    queue.offer(new int[]{newRow, newCol});  // Add the new cell to the queue for further exploration.
                }
            }
        }

        // If no path is found, return false to indicate that it is not possible to cross the grid.
        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1;  // The earliest possible day to cross is day 1.
        int right = row * col;  // The latest possible day to cross is day row * col.

        // Perform a binary search to find the latest day to cross the grid.
        while (left < right) {
            int mid = right - (right - left) / 2;  // Calculate the middle day.

            if (canCross(row, col, cells, mid)) {
                // If it is possible to cross the grid on the middle day,
                // update the left boundary to search for a later day.
                left = mid;
            } else {
                // If it is not possible to cross the grid on the middle day,
                // update the right boundary to search for an earlier day.
                right = mid - 1;
            }
        }

        // Return the left boundary, which represents the latest day to cross the grid.
        return left;
    }
}
