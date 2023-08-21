class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        n = len(s)  # Length of the input string
        for i in range(1, n // 2 + 1):  # Iterate through possible substring lengths
            if n % i == 0:  # Check if the substring length evenly divides the string length
                pattern = s[:i] * (n // i)  # Create a pattern by repeating the substring
                if s == pattern:  # Compare the pattern with the input string
                    return True  # If a repeated substring pattern is found, return True
        return False  # If no repeated substring pattern is found, return False
