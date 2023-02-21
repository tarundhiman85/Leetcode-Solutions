class Solution {
    public int singleNonDuplicate(int[] nums) {
       
       int l = 0; int r=nums.length-1;

       while(l<r){
           // simple check for the condition
           int mid = (r+l)/2;

            if(mid%2==0 && nums[mid+1]==nums[mid]|| mid%2!=0 && nums[mid-1]==nums[mid]){
                l = mid+1;
            }else{
                r = mid;
            }

       }

       return nums[l];

    }
}

/*
   [1,1,2,3,3,4,4,8,8]
           
*/