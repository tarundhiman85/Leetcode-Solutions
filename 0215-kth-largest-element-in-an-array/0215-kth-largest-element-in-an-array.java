class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> heap = new PriorityQueue<>();
       for(int num: nums)
       {
           heap.add(num);
           if(heap.size()>k)
           {
               heap.remove();
           }
       }
        return heap.peek();
    }
}
/* create a min priority queue
  if size exceeds k then pop in the end return top
*/