class Solution:
    def minimumAbsDifference(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        i = 0
        n = len(nums)
        minD = 10**9
        for i in range(n-1):
            if minD >= abs(nums[i] - nums[i+1]):
                minD = abs(nums[i] - nums[i+1])
        # print(minD)    
        i = 0
        while i <= n - 2:
            if minD == abs(nums[i] - nums[i+1]):
                res.append([nums[i], nums[i+1]])
            i += 1
        return res    