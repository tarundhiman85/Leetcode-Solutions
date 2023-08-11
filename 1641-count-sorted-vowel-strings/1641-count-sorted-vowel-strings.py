class Solution:
    def f(self, c, n, vow, k, memo):
        if c == 0:
            return 1

        if k >= len(vow):
            return 0

        if memo[c][k] != -1:
            return memo[c][k]

        result = self.f(c - 1, n, vow, k, memo) + self.f(c, n, vow, k + 1, memo)
        memo[c][k] = result
        return result

    def countVowelStrings(self, n: int) -> int:
        vow = ['a', 'e', 'i', 'o', 'u']
        dp = [[0] * (len(vow) + 1) for _ in range(n + 1)]
        
        # Initialize base cases
        for i in range(len(vow) + 1):
            dp[0][i] = 1
        
        # Fill the dp table
        for c in range(1, n + 1):
            for k in range(len(vow) - 1, -1, -1):
                dp[c][k] = dp[c][k + 1] + dp[c - 1][k]
        
        return dp[n][0]
