class Solution {
     public int search(int[] arr, int target) 
    {    
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(low<=high)
        {
            int mid = low +(high-low)/2;
            if(arr[mid]==target) return mid;
            //the left side is sorted
            if(arr[mid]>=arr[low])
            {
                //figure out if element lies on the left half  eliminate right half
                if(arr[low]<=target && arr[mid]>=target)
                {
                    high=mid-1;
                }
                //eliminate the left half
                else{
                    low=mid+1;
                }
            }
            //right half is sorted
            else{
                //figure out if element lies on right half eliminate left half
                if(arr[mid]<=target && arr[high]>=target)
                {
                    low=mid+1;
                }
                //eliminate the right half
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}