class Solution {
   public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] ans = new int[nums1.length];
    Stack<Integer> stack = new Stack<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    // Find out all the next greater elements in nums2 array
    for (int i = nums2.length - 1; i >= 0; i--) {
        int num = nums2[i];
        // If num is greater than top elements in stack, it is the next greater element in nums2
        while (!stack.isEmpty() && num > stack.peek()) {
            stack.pop();
        }
        // If stack is empty, no greater element found, so -1 is mapped to num
        // Otherwise, the top element in the stack is the next greater element for num
        map.put(num, stack.isEmpty() ? -1 : stack.peek());
        stack.push(num);
    }

    // Iterate over nums1 to find the corresponding next greater elements
    for (int i = 0; i < nums1.length; i++) {
        ans[i] = map.getOrDefault(nums1[i], -1);
    }

    return ans;
}
}