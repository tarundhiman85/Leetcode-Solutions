class Solution {
  public int specialArray(int[] nums) {
	reverseSort(nums);
	return binarySearch(nums);
}

// O(n lg n)/O(n)
private void reverseSort(int[] nums) {
	Arrays.sort(nums);
	for (int i = 0, n = nums.length; i < n / 2; i++)
		swap(n - i - 1, i, nums);
}

private void swap(int i, int j, int[] nums) {
	var temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
}

// O(lg n)/O(1)
private int binarySearch(int[] nums) {
	var low = 0;

	for (var high = nums.length; low < high;) {
		var mid = low + (high - low) / 2;
		
		if (mid < nums[mid])
			low = mid + 1;
		else
			high = mid;
	}
	
	return low < nums.length && low == nums[low] ? - 1 : low;
}
}