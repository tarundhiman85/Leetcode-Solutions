
    class Solution 
{
    public int KadanAlgo(int [] nums){
             //Time Complexity O(n)
        //Kadane's Algortihm - Dynamic Programming Bottom-Up
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        int soln = nums[0];
        int maxSoFar = soln;
        
        
        for (int i = 1; i < nums.length; i++) {
            soln = Math.max(soln + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, soln);
        }
        return maxSoFar;
    }
    public int maxSubarraySumCircular(int[] nums) {
       int x = KadanAlgo(nums);
       int sum=0;
       for(int i=0; i<nums.length; i++)
       {
           sum+=nums[i];
           nums[i]=-nums[i];
       }
       int z = KadanAlgo(nums);
       if(sum+z==0) return x;
       return Math.max(x, sum+z);
    }

}