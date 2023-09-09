class Solution {
    int ans=0;
    public int f(int tar, int[] arr, Integer[] dp){
         if(tar<0)
        {
            return 0;
        }
         if(dp[tar] != null) return dp[tar];
        if(tar==0){
            return 1;
        }
       
       
        int ways=0;
        for(int i=0; i<arr.length; i++){
            ways+=f(tar-arr[i],arr,dp);
        }
        return dp[tar]=ways;
        
    }
    public int combinationSum4(int[] arr, int tar) {
       Integer [] dp = new Integer[tar+1];
       return f(tar,arr,dp);
       
    }
}