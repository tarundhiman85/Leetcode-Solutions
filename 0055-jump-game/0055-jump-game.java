class Solution {
         public boolean canJump(int[] nums) {
        int max=0;
        int n=nums.length;
        int i;
        for( i=0; i<n; i++)
        {
            if(max<i) return false;
            max=Math.max(nums[i]+i, max);
            // System.out.print(max+" ");
        }
        return true;

    }
}