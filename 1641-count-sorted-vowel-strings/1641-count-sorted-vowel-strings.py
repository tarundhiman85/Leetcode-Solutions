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
        memo = [[-1] * len(vow) for _ in range(n + 1)]
        return self.f(n, n, vow, 0, memo)
