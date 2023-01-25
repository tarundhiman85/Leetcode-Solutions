class Solution {
  public int closestMeetingNode(int[] nums, int node1, int node2) {
        if(nums==null || nums.length==0) return -1;
        if(node1==node2) return node1;
        
        int n=nums.length;
        int dist1[]=new int[n];
        int dist2[]=new int[n];
        
        Arrays.fill(dist1,-1);
        Arrays.fill(dist2,-1);
        
        dist1[node1]=0;
        dist2[node2]=0;
        
        boolean vis1[]=new boolean[n];
        boolean vis2[]=new boolean[n];
        
        dfs(nums,node1,dist1,vis1,0);
        dfs(nums,node2,dist2,vis2,0);
        
        int ans=-1;
        int minDist=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(dist1[i]!=-1 && dist2[i]!=-1 && minDist>Math.max(dist1[i],dist2[i])){
                ans=i;
                minDist=Math.max(dist1[i],dist2[i]);
            }
        }
        return ans;
    }
    
    private void dfs(int nums[], int node, int dist[], boolean visited[], int currDist){
        if(node!=-1 && !visited[node]){
            visited[node]=true;
            dist[node]=currDist;
            dfs(nums,nums[node],dist,visited,currDist+1);
        }
    }
}