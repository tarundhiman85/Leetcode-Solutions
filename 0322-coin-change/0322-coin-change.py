import sys

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins) + 1
        m = amount + 1
        dp = [[-1 for _ in range(m)] for _ in range(n)]
        def helper(coins, amount, idx):
            if amount == 0:
                return 0
            
            if idx >= len(coins):
                return sys.maxsize
            
            if dp[idx][amount] != -1:
                return dp[idx][amount]
            
            take = sys.maxsize
            notTake = sys.maxsize
            
            if amount >= coins[idx]:
                take = 1 + helper(coins, amount - coins[idx], idx)
            notTake = helper(coins, amount, idx + 1)
            
            dp[idx][amount] = min(take, notTake)
            
            return dp[idx][amount]
        
        result = helper(coins, amount, 0)
        return result if result != sys.maxsize else -1
