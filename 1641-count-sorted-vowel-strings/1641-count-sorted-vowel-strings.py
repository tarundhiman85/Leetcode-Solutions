class Solution:
    st = ""
    cnt = 0
    def f(self, c, n, vow, k):
        if c == 0:
            self.cnt += 1
            return
        if k >= len(vow):
            return
        self.f(c - 1, n, vow, k)
        self.f(c, n, vow, k + 1)
    def countVowelStrings(self, n: int) -> int:
        
        self.f(n, n, ['a', 'e', 'i', 'o', 'u'], 0)
        return self.cnt
