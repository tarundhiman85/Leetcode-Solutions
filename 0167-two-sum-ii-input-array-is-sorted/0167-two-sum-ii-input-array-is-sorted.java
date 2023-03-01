class Solution {
    public int search(int start, int end, int x, int[] arr){
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==x){
                return mid;
            }
            else if(arr[mid]<x){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int [] answ = new int[2];
        int f=0;
        for(int i=0; i<n && f==0; i++){
           int j=search(i+1,n-1,target-nums[i], nums);
           if(j!=-1 && nums[i]+nums[j]==target)
           {
            answ[0]=i+1;
            answ[1]=j+1;
            f=1;
           }
        }
        return answ;
}
}