class Solution {
public String smallestSubsequence(String S) {
    // Stack to store characters in the desired order
    Stack<Integer> stack = new Stack<>();
    
    // Arrays to keep track of the last occurrence of each character and whether a character has been seen
    int[] last = new int[26]; // Last occurrence of each character
    int[] seen = new int[26]; // Count of each character seen
    
    // Find the last occurrence of each character
    for (int i = 0; i < S.length(); ++i)
        last[S.charAt(i) - 'a'] = i;
    
    // Iterate through the string to build the smallest subsequence
    for (int i = 0; i < S.length(); ++i) {
        int c = S.charAt(i) - 'a'; // Convert character to index (0-25)
        
        // If this character has been seen before, skip it
        if (seen[c]++ > 0) continue;
        
        // Maintain the order and remove larger characters from the stack
        while (!stack.isEmpty() && stack.peek() > c && i < last[stack.peek()])
            seen[stack.pop()] = 0; // Remove characters from 'seen' as they are removed from the stack
        
        // Add the current character to the stack
        stack.push(c);
    }
    
    // Build the final string using characters in the stack
    StringBuilder sb = new StringBuilder();
    for (int i : stack) sb.append((char)('a' + i)); // Convert index back to character
    
    return sb.toString(); // Return the lexicographically smallest subsequence
}

}
