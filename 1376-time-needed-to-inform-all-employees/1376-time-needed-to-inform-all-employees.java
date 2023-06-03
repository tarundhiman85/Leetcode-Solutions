class Solution {

  int maxTime = Integer.MIN_VALUE;

public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

    ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(n);

    for (int i = 0; i < n; i++) {
        adjList.add(new ArrayList<Integer>());
    }

    // Making an adjacent list, each index stores the Ids of subordinate employees.
    for (int i = 0; i < n; i++) {
        if (manager[i] != -1) {
            adjList.get(manager[i]).add(i);
        } 
    }

    Queue<Pair<Integer, Integer>> q = new LinkedList<>();
    q.add(new Pair<>(headID, informTime[headID]));

    while (!q.isEmpty()) {
        Pair<Integer, Integer> employeePair = q.remove();

        int parent = employeePair.getKey();
        int time = employeePair.getValue();
        maxTime = Math.max(maxTime, time);
        for (int adjacent : adjList.get(parent)) {
            q.add(new Pair<>(adjacent, time + informTime[adjacent]));
        }
    }

    return maxTime;
}
}