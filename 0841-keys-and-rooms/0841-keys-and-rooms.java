class Solution {
    public void dfs(List<List<Integer>> adj, boolean[] visited, int node)
    {
     visited[node] = true;
     for(int x: adj.get(node))
     {
         if(!visited[x])
         {
             dfs(adj, visited, x);
         }
     }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int V = rooms.size();
        boolean[] visited = new boolean[V];
        dfs(rooms, visited, 0);
        for(int i=0; i<V; i++)
        {
            if(!visited[i]) return false;
        }
        return true;
    }
}