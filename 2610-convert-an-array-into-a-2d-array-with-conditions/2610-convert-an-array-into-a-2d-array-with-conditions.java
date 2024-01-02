class Solution {
   public  List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int i=0;
        while(i<n)
        {
            int j = i;
            while(j<n)
            {
                int elem = nums[j];
                if (ans.size() <= i && elem > 0)
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(elem);
                    ans.add(temp);
                    nums[j] = -nums[j];
                }
                if(ans.size() > i && !ans.get(i).contains(elem) && elem > 0)
                {
                    ans.get(i).add(elem);
                    nums[j] = -nums[j];
                }
                j++;
            }
            i++;
        }
        return ans;
    }
}