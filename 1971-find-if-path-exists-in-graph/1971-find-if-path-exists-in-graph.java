class Solution {
   public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++)
        {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(graph, source, destination, visited);
    }
    public boolean dfs(ArrayList<Integer>[] graph, int source, int destination, boolean[] visited)
    {
        if(source==destination) return true;
        visited[source] = true;
        for(int i=0;i<graph[source].size();i++)
        {
            if(!visited[graph[source].get(i)])
            {
                if(dfs(graph, graph[source].get(i), destination, visited)) return true;
            }
        }
        return false;
    }
}