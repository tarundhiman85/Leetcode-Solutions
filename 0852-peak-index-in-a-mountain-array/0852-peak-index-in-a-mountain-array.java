class Solution {
    public int peakIndexInMountainArray(int[] arr) {
      //[]  <  []  < arr[i] > []  > []  > []
      /*
       follow this pattern A[mi] < A[mi+1] will give [t, t, t, f, f, f]
       return the lowerbound because we just need a point 
       we are already given a mountain array
      */
       int low = 0;
       int high = arr.length - 1;
       while(low < high)
       {
           int mid = low + (high - low) / 2;
           if( arr[mid] < arr[mid+1] )
           {
               low = mid + 1;
           }
           else 
           {
               high = mid;
           }
       }
        return low;
    }
}