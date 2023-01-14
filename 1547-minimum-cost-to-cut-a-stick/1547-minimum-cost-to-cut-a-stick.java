class Solution {
    public int f(int i, int j, List<Integer> cuts, Integer[][] dp)
    {
        if(i>j) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int ind = i; ind <= j; ind++)
        {
            int cost = cuts.get(j+1) - cuts.get(i-1) + f(i, ind-1, cuts, dp) + f(ind+1, j, cuts, dp);
            mini = Math.min(mini, cost);
        }
        return dp[i][j] = mini;
    }
    public int minCost(int n, int[] cuts) {
       //convert array to list
        List<Integer> list = new ArrayList<>();
        for(int i:cuts){
            list.add(i);
        }
        //add 0 and n to the list
        list.add(0);
        list.add(n);
        //sort the list
        Collections.sort(list);
        //create a 2d array to store the min cost
        Integer[][] dp = new Integer[list.size()][list.size()];
        //call the helper function
        return f(1,cuts.length,list, dp);
    }
}