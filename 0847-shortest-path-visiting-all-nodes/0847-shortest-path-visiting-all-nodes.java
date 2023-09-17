class Solution {
    public int shortestPathLength(int[][] graph) {
        // Get the number of nodes in the graph
        int n = graph.length;

        // Calculate a bitmask to represent all nodes as visited
        int allVisited = (1 << n) - 1;

        // Create a queue to perform Breadth-First Search
        Queue<int[]> queue = new ArrayDeque<>();

        // Create a HashSet to keep track of visited states
        HashSet<Integer> visited = new HashSet<>();

        // Initialize the queue and visited set with starting nodes
        for (int i = 0; i < n; i++) {
            // Initialize the state as a bitmask with only one node set to 1
            // The format is (mask << 16) + currentNode, where 16 is an arbitrary multiplier
            queue.offer(new int[] { 1 << i, i, 0 });
            visited.add((1 << i) * 16 + i);
        }

        // Perform Breadth-First Search
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            // If all nodes have been visited, return the current distance
            if (cur[0] == allVisited) {
                return cur[2];
            }

            // Iterate through neighbors of the current node
            for (int neighbor : graph[cur[1]]) {
                // Calculate a new bitmask by setting the neighbor node to 1
                int newMask = cur[0] | (1 << neighbor);

                // Calculate a unique hash value for the new state
                int hashValue = newMask * 16 + neighbor;

                // If this state has not been visited before, add it to the visited set and the queue
                if (!visited.contains(hashValue)) {
                    visited.add(hashValue);
                    queue.offer(new int[] { newMask, neighbor, cur[2] + 1 });
                }
            }
        }

        // If no path exists, return -1
        return -1;
    }
}