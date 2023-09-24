class Solution:
    def maximumSumOfHeights(self, A):
        n = len(A)

        # Initialize an array to store the left part of the maximum sum of heights
        left = [0] * n

        # Initialize a stack to keep track of indices
        stack = []

        # Push a sentinel value -1 onto the stack to handle the first element
        stack.append(-1)

        # Initialize variables to store the result and current sum
        res = 0
        cur = 0

        # Loop through the elements in the list
        for i in range(n):
            # Keep popping elements from the stack as long as they are greater than the current element
            while len(stack) > 1 and A[stack[-1]] > A[i]:
                j = stack.pop()
                cur -= (j - stack[-1]) * A[j]

            # Calculate the current sum
            cur += (i - stack[-1]) * A[i]

            # Push the current index onto the stack
            stack.append(i)

            # Store the current sum in the left array
            left[i] = cur

        # Clear the stack and push a sentinel value n onto the stack to handle the last element
        stack.clear()
        stack.append(n)
        cur = 0

        # Loop through the elements in reverse order
        for i in range(n - 1, -1, -1):
            # Keep popping elements from the stack as long as they are greater than the current element
            while len(stack) > 1 and A[stack[-1]] > A[i]:
                j = stack.pop()
                cur -= -(j - stack[-1]) * A[j]

            # Calculate the current sum (note the negative sign)
            cur += -(i - stack[-1]) * A[i]

            # Push the current index onto the stack
            stack.append(i)

            # Update the result with the maximum sum of heights
            res = max(res, left[i] + cur - A[i])

        # Return the maximum sum of heights
        return res