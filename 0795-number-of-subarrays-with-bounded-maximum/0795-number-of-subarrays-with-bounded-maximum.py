class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        def count(bound):
            ans = cnt = 0
            for x in nums:
                cnt = cnt + 1 if x <= bound else 0
                ans += cnt
            return ans

        return count(right) - count(left - 1)