class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        
        n = len(nums)
        i = 0
        j = 0
        
        st = set()
        for k in range(n):
            st.add(nums[k])
        
        ans = 0
        while i<n:
            chk = set()
            j = i
            while j<n:
                chk.add(nums[j])
                j += 1
                if chk == st:
                    ans += 1
            i += 1    
        return ans    