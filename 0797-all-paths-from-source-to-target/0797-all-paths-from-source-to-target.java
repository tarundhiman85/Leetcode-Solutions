class Solution {
       List<List<Integer>> result;
    public void dfs(List<List<Integer>> adj, boolean [] vis, ArrayList<Integer> curr, int target, int node)
    {
        if(node==target)
        {
            curr.add(target);
            result.add(new ArrayList<>(curr));
            return;
        }
        vis[node] = true;
        curr.add(node);
        for(Integer vertex: adj.get(node))
        {
            if(!vis[vertex])
            {
                dfs(adj, vis, curr, target, vertex);
                curr.remove(curr.size()-1);
                vis[vertex] = false;
            }
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = graph.length;
        boolean [] vis = new boolean[V];
        for(int i=0; i<=V; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<V; i++)
        {
            for(int j=0; j<graph[i].length; j++)
            {
                adj.get(i).add(graph[i][j]);
            }
        }
        //make a dfs call if target is found then add the cuurent arraylist to the result
        result = new ArrayList<>();
        dfs(adj, vis, new ArrayList<>(),  V-1, 0);
        return result;
    }
}