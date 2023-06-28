class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Create a graph to represent the connections between nodes
        // Each node is represented by an integer key
        // The value is a list of pairs representing the neighboring node and the probability of reaching that node from the current node
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();

        // Iterate over the edges array
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double pathProb = succProb[i];
            
            // Add the edge from node u to node v with the given probability
            // Add the edge from node v to node u with the same probability
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, pathProb));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, pathProb));
        }

        // Create an array to store the maximum probability of reaching each node
        // Initialize the maximum probability of the start node to 1 (as we start from the start node)
        double[] maxProb = new double[n];
        maxProb[start] = 1d;

        // Create a priority queue to keep track of nodes with the highest probabilities
        // The priority queue is ordered by the maximum probability (in descending order)
        // The pair contains the probability and the node index
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> -Double.compare(a.getKey(), b.getKey()));

        // Add the start node to the priority queue with the maximum probability
        pq.add(new Pair<>(1.0, start));

        // Perform a breadth-first search (BFS) using Dijkstra's algorithm
        while (!pq.isEmpty()) {
            // Get the node with the highest probability from the priority queue
            Pair<Double, Integer> cur = pq.poll();
            double curProb = cur.getKey();
            int curNode = cur.getValue();

            // If we reach the end node, return the current probability
            if (curNode == end) {
                return curProb;
            }

            // Iterate over the neighbors of the current node
            for (Pair<Integer, Double> nxt : graph.getOrDefault(curNode, new ArrayList<>())) {
                int nxtNode = nxt.getKey();
                double pathProb = nxt.getValue();

                // Calculate the probability of reaching the next node by multiplying the current probability with the path probability
                double newProb = curProb * pathProb;

                // If the new probability is greater than the maximum probability recorded for the next node,
                // update the maximum probability and add the next node to the priority queue
                if (newProb > maxProb[nxtNode]) {
                    maxProb[nxtNode] = newProb;
                    pq.add(new Pair<>(maxProb[nxtNode], nxtNode));
                }
            }
        }

        // If we cannot reach the end node, return 0
        return 0d;
    }
}
