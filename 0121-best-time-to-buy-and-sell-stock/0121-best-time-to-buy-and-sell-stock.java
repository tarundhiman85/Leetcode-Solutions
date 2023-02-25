class Solution {
    public int maxProfit(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(min>arr[i]){
                min=arr[i];
            }
            else if(arr[i]-min>max){
                max=arr[i]-min;
            }
        }
        return max;
    }
}