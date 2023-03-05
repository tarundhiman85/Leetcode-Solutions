class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> valIndex = new HashMap<>();
        for(int i = 0; i<n; i++)
        {
            valIndex.computeIfAbsent(arr[i], l->new ArrayList<>()).add(i);
        }
        //for BFS
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(0);
        visited.add(0);
        int steps = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size-->0)
            {
                //we fetch the first vertex
                int i = q.poll();
                if(n-1 == i)
                {
                    return steps;
                }
                List<Integer> adjList = valIndex.get(arr[i]);
                //after that we will add two more places which we can go for next iteration right?
                adjList.add(i - 1);
                adjList.add(i + 1);
                //for all vertex in adjaceny list
                for(int j: adjList)
                {
                    if(j>=0 && j<n && !visited.contains(j))
                    {
                        q.add(j);
                        visited.add(j);
                    }
                }
                adjList.clear();
            }
            steps++;
        }
        return -1;
    }
}