class Solution {
    private int findUpperBound(int[] A, int target, int right) {
        if (right == 0)
            return 0;
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int lisLength = 0;
        
        int[] answer = new int[n];
        int[] lis = new int[n];
        
        for(int i=0; i<n; i++)
        {
            int height = obstacles[i];
            //find the exact postion
            int idx = findUpperBound(lis, height, lisLength);
            
            if(idx == lisLength)
            {
                lisLength++;
            }
            //put the element at that index
            lis[idx] = height;
            //and increase the anser for that index
            answer[i] = idx + 1;
        }
        return answer;
    }
}