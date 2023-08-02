class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, nums);
        return ans;
    }
    
    public void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for (int num: nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, ans, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
/*
if(n==0)
{
 res.save(arr)
 return;
}
  for j in range(n):
    res.add(arr[i])
    //swap(arr[i], arr[j])
    f(arr,i+1)
    res.remove(arr[i])
    //swap(arr[i], arr[j])
*/