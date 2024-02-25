class UnionFind:
    def __init__(self, n):
        # every node is its own parent
        self.par = [i for i in range(n)]
        # union by size
        self.size = [1] * n
        # no of components
        self.count = n
        
    def find(self, x):
        if self.par[x] != x:
            self.par[x] = self.find(self.par[x])
        return self.par[x]
    
    def union(self, x, y):
        px, py = self.find(x), self.find(y)
        if px == py:
            return
        if self.size[px] < self.size[py]:
            self.par[px] = py
            self.size[py] += self.size[px]
        else:
            self.par[py] = px
            self.size[px] += self.size[py]
        self.count -= 1
        
class Solution:
    def canTraverseAllPairs(self, nums: List[int]) -> bool:
        
        uf = UnionFind(len(nums))
        
        factor_index = {}  # f -> index of value with factor f
        
        for i, n in enumerate(nums):
            f = 2
            # if square root of the factor is less then number then we continue
            while f * f <= n:
                # if f is factor of n
                if n % f == 0:
                    if f in factor_index:
                        # union the current number and the previous number that also has same factor
                        uf.union(i, factor_index[f])
                    else:
                        # otherwise we are finding first number with the index
                        factor_index[f] = i
                        
                    while n % f == 0:
                        # eliminate that factor as many times as we can
                        n = n // f
                f += 1  
            if n > 1:
                if n in factor_index:
                    uf.union(i, factor_index[n])
                else:
                    factor_index[n] = i
        
        return uf.count == 1