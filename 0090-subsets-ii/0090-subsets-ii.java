class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Sort the array to ensure duplicate elements are adjacent
        Arrays.sort(nums);
        
        // Create a list to store the final subsets
        List<List<Integer>> finalList = new ArrayList<>();
        
        // Start finding subsets from index 0
        findSubsets(0, nums, new ArrayList<>(), finalList);
        
        // Return the final list of subsets
        return finalList;
    }
    
    // Recursive function to find subsets
    public void findSubsets(int index, int[] nums, List<Integer> ds, List<List<Integer>> finalList) {
        // Add the current subset to the final list
        finalList.add(new ArrayList<>(ds));
        
        // Iterate through the remaining elements from the current index
        for (int i = index; i < nums.length; i++) {
            // If the current element is a duplicate and not the first occurrence, skip it
            //i!=index to avoid nums[-1]
            if (i != index && nums[i] == nums[i-1])
                continue;
            
            // Add the current element to the current subset
            ds.add(nums[i]);
            
            // Recursively find subsets starting from the next index
            findSubsets(i + 1, nums, ds, finalList);
            
            // Remove the current element from the current subset
            ds.remove(ds.size() - 1);
        }
    }
}
