#User function Template for python3
class Solution:
    def maxSumIS(self, arr, n):
        dp = [1] * n
        res = 0
        sum_arr = arr.copy()

        for i in range(n):
            temp = arr[i]
            for j in range(i - 1, -1, -1):
                if arr[i] > arr[j]:
                    dp[i] = max(dp[j] + 1, dp[i])
                    temp = max(temp, sum_arr[i] + sum_arr[j])
            sum_arr[i] = temp;
            res = max(sum_arr[i], res)

        return res

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
	T=int(input())
	for i in range(T):
		n = int(input())
		Arr = [int(x) for x in input().split()]
		ob = Solution()
		ans = ob.maxSumIS(Arr,n)
		print(ans)

# } Driver Code Ends