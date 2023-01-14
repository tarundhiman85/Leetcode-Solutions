class Solution {
    // public int f(int i, int j, List<Integer> cuts, Integer[][] dp)
    // {
    //     if(i>j) return 0;
    //     if(dp[i][j]!=null) return dp[i][j];
    //     int mini = Integer.MAX_VALUE;
    //     for(int ind = i; ind <= j; ind++)
    //     {
    //         int cost = cuts.get(j+1) - cuts.get(i-1) + f(i, ind-1, cuts, dp) + f(ind+1, j, cuts, dp);
    //         mini = Math.min(mini, cost);
    //     }
    //     return dp[i][j] = mini;
    // }
    // public int minCost(int n, int[] cuts) {
    //    //convert array to list
    //     List<Integer> list = new ArrayList<>();
    //     for(int i:cuts){
    //         list.add(i);
    //     }
    //     //add 0 and n to the list
    //     list.add(0);
    //     list.add(n);
    //     //sort the list
    //     Collections.sort(list);
    //     //create a 2d array to store the min cost
    //     Integer[][] dp = new Integer[list.size()][list.size()];
    //     //call the helper function
    //     return f(1,cuts.length,list, dp);
    // }
     public int minCost(int n, int[] cuts) {
        
        int len = cuts.length;
        
        Arrays.sort(cuts);
        
        int[] arr = new int[len+2];
        for(int i = 1 ; i <= len ; i++)
            arr[i] = cuts[i-1];
        
        arr[0] = 0;
        arr[len+1] = n;
        int[][] dp = new int[len+2][len+2];
        
        for(int i = len ; i >= 1 ; i--){
            for(int j = 1 ; j <= len ; j++)
            {
                if(i > j)   continue;
                    
                int mini = Integer.MAX_VALUE;
                for(int k = i ; k <= j ; k++){
                    mini = Math.min(arr[j+1]-arr[i-1] + dp[i][k-1] + dp[k+1][j] , mini);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][len];
    }
}