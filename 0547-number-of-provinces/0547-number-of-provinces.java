class Solution {
    public void dfs(int node, int[][] arr, boolean[] vis)
    {
        vis[node] = true;
        for(int i=0; i< arr.length; i++)
        {
            if(arr[node][i]==1 && !vis[i])
            {
                dfs(i, arr, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int nC = 0;
        boolean[] vis = new boolean[n];
        
        for(int i=0; i<n; i++)
        {
            if(!vis[i])
            {
                nC++;
                dfs(i , isConnected, vis);
            }
        }
        return nC;
    }
}