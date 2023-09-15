class Solution {
    // Helper function to calculate Manhattan distance between two points
    public static int manhattan_distance(int[] p1, int[] p2)
    {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
    // Function to find the minimum cost to connect all points in a graph
    public int minCostConnectPoints(int[][] points) 
    {
        int n = points.length; // Number of points
        boolean[] visited = new boolean[n]; // To keep track of visited points
        HashMap<Integer, Integer> heap_dict = new HashMap<>(); // To store distances to each point
        // Initialize heap_dict with the first point (0 distance to itself)
        heap_dict.put(0, 0);
        // Create a priority queue (min heap) to store edges (distance, point)
        PriorityQueue<int[]> min_heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        // Add the first point to the min_heap (distance 0 to itself)
        min_heap.add(new int[]{0, 0});
        
        int mst_weight = 0;
        // Main loop to build the Minimum Spanning Tree
        while(!min_heap.isEmpty())
        {
            int[] top = min_heap.poll(); //Get the edge with the smallest distance
            int w = top[0];  // Distance of the edge
            int u = top[1];   // Starting point of the edge
            // If the destination point is already visited or there's a shorter path to it, skip this edge
            if(visited[u] || heap_dict.getOrDefault(u, Integer.MAX_VALUE) < w) continue;
            
            visited[u] = true; // Mark the point as visited
            mst_weight += w; // Add the edge weight to the MST weight
            
        // Explore all neighboring points
            for (int v = 0; v < n; ++v) {
                if (!visited[v]) {
                    int new_distance = manhattan_distance(points[u], points[v]); // Calculate distance to the neighboring point
                    // If the new distance is smaller than the current recorded distance to v, update it
                    if (new_distance < heap_dict.getOrDefault(v, Integer.MAX_VALUE)) {
                        heap_dict.put(v, new_distance); // Update the distance in heap_dict
                        min_heap.add(new int[]{new_distance, v}); // Add the edge to the min_heap
                    }
                }
            }
        }
        
        return mst_weight; // Return the total weight of the Minimum Spanning Tree

    }
}