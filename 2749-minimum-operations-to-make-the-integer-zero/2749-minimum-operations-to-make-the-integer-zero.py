class Solution:
    def makeTheIntegerZero(self, num1: int, num2: int) -> int:
        # If num1 is smaller than or equal to num2, it's impossible to make num1 zero.
        if num1 <= num2:
            return -1
        
        # If num1 is already 0, return 0.
        if num1 == 0:
            return 0
        
        # Iterate through possible values of 'l'.
        for l in range(100):
            # Calculate the difference between num1 and l * num2.
            diff = num1 - (l * num2)
            
            # Count the number of set bits ('1' bits) in the binary representation of diff.
            set_bits_count = bin(diff).count('1')
            
            # If the set bits count is greater than 'l', continue to the next iteration.
            if set_bits_count > l:
                continue
            
            maxBits = 0
            # Calculate the maximum bits that can be obtained by choosing specific bits from diff.
            for mask in range(61):
                if ((1 << mask) & diff) != 0:  # Check if the bit at 'mask' position is set in diff.
                    maxBits += (1 << mask)
            
            # If the difference is greater than or equal to 'l', return 'l'.
            if diff >= l:
                return l
        
        # If no solution is found, return -1.
        return -1
