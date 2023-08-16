class Solution {
    class Data
    {
        int val;
        int index;
        Data(int val, int index)
        {
            this.val = val;
            this.index = index;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // We will have n - k + 1 elements in the output window
        int [] win = new int[n - k + 1];
        // Create a max priority queue using a custom comparator to order elements based on their values
        PriorityQueue<Data> maxQueue = new PriorityQueue<Data>((a,b)->{
            return b.val - a.val;
        });
        // Add the first k elements to the maxQueue
        for(int i = 0 ; i < k; ++i){
            maxQueue.add(new Data(nums[i],i));
        }
        // The first element of the output window is the maximum of the initial k elements
        win[0] = maxQueue.peek().val;
        // Process the remaining elements        
        for(int i = k; i < nums.length; i++)
        {
            // Remove elements from the maxQueue that are no longer within the sliding window's range            
            while(maxQueue.size() > 0 && maxQueue.peek().index <= (i-k))
            {
                maxQueue.poll();
            }
            // Add the current element to the maxQueue            
            maxQueue.add(new Data(nums[i], i));
            // The maximum of the current sliding window is the maximum element in the maxQueue            
            win[i-k+1] = maxQueue.peek().val;
        }
        return win;
    }
}

