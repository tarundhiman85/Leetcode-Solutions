class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];
        
        for(int i=0; i<len; i++)
        {
            if(colors[i]==1 || colors[i]==-1) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            colors[i] = 1;
            
            while(!queue.isEmpty())
            {
                int curr = queue.poll();
                for(int next : graph[curr])
                {
                    if(colors[next]==0)
                    {
                        colors[next] = -colors[curr];
                        queue.add(next);
                    }
                    if(colors[next]==colors[curr]) return false;
                }
            }
        }
        return true;
    }
}