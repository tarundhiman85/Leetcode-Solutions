class Solution {
    //DFS for Counting Detonations:
// The code defines a helper function called dfs that performs the depth-first search.
// The dfs function takes the graph gr, an array visited to track visited bombs, an array c to store the count of reachable bombs, and the current bomb index i as parameters.
// It marks the current bomb as visited, increments the count c[0], and then recursively calls the dfs function on all the neighboring bombs that have not been visited.
// The base case for the recursive function is when there are no more unvisited neighboring bombs.
    private void dfs(List<List<Integer>> gr, boolean[] visited, int[] c, int i) {
        visited[i] = true;
        c[0]++;
        for (int j : gr.get(i)) {
            if (!visited[j]) {
                dfs(gr, visited, c, j);
            }
        }
    }

    //In summary, this code constructs a graph of bombs where each bomb is a node, and there is an edge between two bombs if one can detonate the other. It then performs a DFS from each bomb to count the number of reachable bombs. The maximum count obtained from the DFS represents the maximum number of bombs that can be detonated.
    
    public int maximumDetonation(int[][] bombs) {
        //The code initializes a list of lists called gr to represent the graph of bombs. Each index i in the list corresponds to a bomb, and the inner list contains the indices of bombs that can be detonated by bomb i.
        int n = bombs.length;
        List<List<Integer>> gr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            gr.add(new ArrayList<>());
            //For each bomb, it iterates over all other bombs and checks if the current bomb can detonate the other bomb.
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    long x1 = bombs[i][0];
                    long y1 = bombs[i][1];
                    long r1 = bombs[i][2];
                    long x = bombs[j][0];
                    long y = bombs[j][1];
                    //If the distance between the centers of the bombs is less than or equal to the square of the radius of the first bomb, it means that the first bomb can detonate the second bomb.
                    long distanceSq = (x - x1) * (x - x1) + (y - y1) * (y - y1);
                    if (distanceSq <= r1 * r1) {
                        gr.get(i).add(j);
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] c = new int[1];
            boolean[] visited = new boolean[n];
            dfs(gr, visited, c, i);
            ans = Math.max(ans, c[0]);
        }

        return ans;
    }
}