class Solution:
    @staticmethod
    def binary_search(arr, target):
        left, right = 0, len(arr) - 1

        while left <= right:
            mid = left + (right - left) // 2

            if arr[mid] == target:
                return True
            elif arr[mid] < target:
                left = mid + 1
            else:
                right = mid - 1

        return False
    
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        n = len(matrix)
        m = len(matrix[0])
        rowWise = False
        for i in range(n):
            if matrix[i][m-1] >= target:
                rowWise = rowWise or self.binary_search(matrix[i], target)
        return rowWise
