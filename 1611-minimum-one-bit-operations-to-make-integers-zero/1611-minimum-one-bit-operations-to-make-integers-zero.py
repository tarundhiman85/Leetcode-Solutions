class Solution:
    def minimumOneBitOperations(self, n):
        if n == 0:
            return 0

        shift_, currend = 0, 1

        while currend * 2 <= n:
            currend *= 2
            shift_ += 1
            
        min_operation = (1 << (shift_ + 1)) - 1 - self.minimumOneBitOperations(n ^ currend)

        return min_operation