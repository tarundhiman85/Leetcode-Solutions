class Solution {
    public int power(int x, int y) {
        if (y == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
     }
    public int findKOr(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<32; i++)
        {
            int count = 0;
            for(int j=0; j<n; j++)
            {
                if(((nums[j] >> i) & 1) == 1)
                {
                    count++;
                }
            }
            if(count>=k)
            {
                set.add(i);
            }
        }
        int ans = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) 
        {
            Integer ele = iterator.next();
            ans += power(2, ele);
            iterator.remove();
        }
        return ans;
    }
}