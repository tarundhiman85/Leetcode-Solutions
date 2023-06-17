class Solution {
public int orangesRotting(int[][] grid) {
    // Variables to keep track of the dimensions of the grid
    int rows = grid.length;
    int cols = grid[0].length;
    
    // Queue to store the coordinates of rotten oranges
    Queue<int[]> queue = new LinkedList<>();
    
    // Variables to keep track of fresh oranges, minutes, and count of rotten oranges
    int freshOranges = 0;
    int minutes = 0;
    int rottenOranges = 0;
    
    // Add the coordinates of rotten oranges to the queue and count fresh oranges
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == 2) {
                queue.offer(new int[]{i, j});
                rottenOranges++;
            } else if (grid[i][j] == 1) {
                freshOranges++;
            }
        }
    }
    
    // If there are no fresh oranges, return 0 (no need to rot any oranges)
    if (freshOranges == 0) {
        return 0;
    }
    
    // Array to keep track of the adjacent directions
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    // Perform BFS to rot the oranges
    while (!queue.isEmpty()) {
        int size = queue.size();
        
        // Process the oranges in the current minute
        for (int i = 0; i < size; i++) {
            int[] orange = queue.poll();
            int row = orange[0];
            int col = orange[1];
            
            // Check the adjacent oranges
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                
                // If the adjacent orange is fresh, rot it and add it to the queue
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 2;
                    queue.offer(new int[]{newRow, newCol});
                    rottenOranges++;
                    freshOranges--;
                }
            }
        }
        
        // Increment the minutes after processing all oranges in the current minute
        if (!queue.isEmpty()) {
            minutes++;
        }
    }
    
    // If there are still fresh oranges left, return -1 (unable to rot all oranges)
    if (freshOranges > 0) {
        return -1;
    }
    
    return minutes;
}

}