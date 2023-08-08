class Solution(object):
    def search(self, arr, target):
        n = len(arr)
        low = 0
        high = n - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if arr[mid] == target:
                return True
            
            # The left side is sorted
            if arr[mid] > arr[low]:
                # Figure out if element lies on the left half, eliminate right half
                if arr[low] <= target <= arr[mid]:
                    high = mid - 1
                # Eliminate the left half
                else:
                    low = mid + 1
            # Right half is sorted
            elif arr[mid] < arr[low]:
                # Figure out if element lies on the right half, eliminate left half
                if arr[mid] <= target <= arr[high]:
                    low = mid + 1
                # Eliminate the right half
                else:
                    high = mid - 1
            # Duplicate elements case
            else:
                low += 1
        
        return False


        