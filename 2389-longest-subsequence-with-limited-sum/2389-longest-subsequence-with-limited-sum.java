class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
     Arrays.sort(nums);
        int n = nums.length;
        int[] prefix = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++)
        {
            sum += nums[i];
            prefix[i] = sum;
        }
        int [] result = new int[queries.length];
        //we will check the lowerbound if it exists or return 0
        for(int i=0; i<queries.length; i++){
           int q = queries[i];
           int ind = Arrays.binarySearch(prefix, q);
           if(ind<0){
               result[i] = Math.abs(ind)-1;
           }
           else{
               result[i] = ind+1;
           }
        }
        return result; 
    }
}