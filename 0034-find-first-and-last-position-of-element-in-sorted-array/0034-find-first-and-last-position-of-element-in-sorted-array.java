class Solution {
    public int lowerBound(int [] arr, int x)
    {
        int low = 0;
        int high = arr.length-1;
        
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid]==x)
            {
                if(mid==0 || arr[mid-1]!=x)
                {
                    return mid;
                }
                high=mid-1;
            }
            else if(arr[mid]<x)
            {
                low=mid+1;
            }
            else{
                high=mid-1;
            }
            
        }
        return -1;
    }
    public int higherBound(int [] arr, int x)
    {
        int low = 0;
        int high = arr.length-1; 
        
        while(low<=high)
        {
            int mid = low+(high-low)/2;
             // System.out.print("Ele"+" "+arr[mid]+" ");
            if(arr[mid]==x)
            {
                // System.out.print("Ele"+" "+arr[mid]+" ");
                if(mid==arr.length-1 || arr[mid+1]!=x)
                {
                    return mid;
                }
                low=mid+1;
            }
            else if(arr[mid]<x)
            {
                low=mid+1;
            }
            else{
                high=mid-1;
            }
            
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
     int[] ans = {lowerBound(nums,target), higherBound(nums,target)};
     return ans;   
    }
}