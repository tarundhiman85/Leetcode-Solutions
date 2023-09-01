class Solution:
    def countBits(self, n: int) -> List[int]:
        dp = [0] * (n + 1)
        
        if n >= 1:
            dp[1] = 1
        
        if n >= 2:
            dp[2] = 1
        
        if n >= 3:
            dp[3] = 2
        
        pow2 = 4
        i = 4
        
        while i <= n:
            for j in range(pow2, 0, -1):
                dp[i] = dp[i - pow2] + 1
                i += 1
                if i > n:
                    break
            pow2 *= 2
        
        return dp