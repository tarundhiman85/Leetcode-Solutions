class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i=0;i<scores.length;i++){
            arr.add(new int[]{ages[i],scores[i]});
        }
        arr.sort((a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);        
        return (int)lis(arr);
    }
    long lis(ArrayList<int[]> arr){
        long[] dp = new long[arr.size()];
        long max = 0;
        for(int i=0;i<arr.size();i++){
            dp[i] = arr.get(i)[1];
            for(int j=0;j<i;j++){
                if(arr.get(j)[1]<=arr.get(i)[1]){
                    dp[i] = Math.max(dp[i],dp[j]+arr.get(i)[1]);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
/*
for each index
    i can choose it or not choose it
       if i choose it
         i need to make sure that previous player fits in else skip
       else i will skip it  
*/