class Solution {
    public static HashMap<Integer, ArrayList<Integer>> createGraph(int n, int[][] edges){
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    
    for(int[] currEdge: edges){
        graph.putIfAbsent(currEdge[0], new ArrayList<Integer>());
        graph.get(currEdge[0]).add(currEdge[1]);
    }
    return graph;
}
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

    HashMap<Integer, ArrayList<Integer>> redGraph = createGraph(n, redEdges);
    HashMap<Integer, ArrayList<Integer>> blueGraph = createGraph(n, blueEdges);
    //[0] steps, [1] color
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[n][2];
    int[] result = new int[n];
    Arrays.fill(result, -1);
    
    //0 -> red
    //1 -> blue
    queue.offer(new int[]{0, 0}); // starting with Red Edges
    queue.offer(new int[]{0, 1}); //starting with Blue Edges
    visited[0][0] = true;
    visited[0][1] = true;
    int step = 0;
    while(!queue.isEmpty()){
        int size = queue.size();
        
        while(size-- != 0){
            int[] curr = queue.poll();
            	//minimum Steps till this level
            result[curr[0]] = result[curr[0]]==-1 ? step : Math.min(result[curr[0]], step);  
            
            if(curr[1] == 1){ //at Blue so go with Red edges
                if(redGraph.containsKey(curr[0])){
                    for(int i: redGraph.get(curr[0])){
                        if(visited[i][0])
                            continue;
                        
                        queue.offer(new int[]{i, 0});
                        visited[i][0] = true;
                    }
                }
            }
            else{ //at RED Edge so go with Blue Edges
                if(blueGraph.containsKey(curr[0])){
                    for(int i: blueGraph.get(curr[0])){
                        if(visited[i][1])
                            continue;
                        
                        queue.offer(new int[]{i, 1});
                        visited[i][1] = true;
                    }
                }
            }
        }
        step++;
    }
    return result; 
    }
}