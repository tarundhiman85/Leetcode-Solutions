class Solution {
    public static class Pair {
        int element;
        int index;

        Pair(int element, int index) {
            this.element = element;
            this.index = index;
        }
    }
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
            int n = nums.length;

            // Create a list of Pair objects containing elements and their original indices
            List<Pair> pairs = new ArrayList<>();
            for (int i = 0; i < n; ++i)
                pairs.add(new Pair(nums[i], i));

            // Sort the pairs based on their elements
            pairs.sort(Comparator.comparingInt(p -> p.element));

            // Initialize a list to store grouped pairs based on the limit
            List<List<Pair>> result = new ArrayList<>();
            result.add(new ArrayList<>(Arrays.asList(pairs.get(0))));

            // Group pairs based on the limit
            for (int i = 1; i < n; ++i) {
                if (pairs.get(i).element - pairs.get(i - 1).element <= limit)
                    result.get(result.size() - 1).add(pairs.get(i));
                else
                    result.add(new ArrayList<>(Arrays.asList(pairs.get(i))));
            }

            // Rearrange the elements in each group in the original array order
            for (List<Pair> group : result) {
                List<Pair> sortedGroup = new ArrayList<>(group);
                sortedGroup.sort(Comparator.comparingInt(p -> p.index));

                for (int i = 0; i < group.size(); ++i)
                    nums[sortedGroup.get(i).index] = group.get(i).element;
            }

            // Return the modified array
            return nums;
        }
}