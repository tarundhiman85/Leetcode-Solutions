class Solution {
    public boolean canMakeSubsequence(String a, String b) {
        int n = a.length();
        int m = b.length();
        if(n < m)
        {
            return false;
        }
        int j = 0;
        
        for(int i=0; i<n && j<m; i++){
             // Convert the current character in string a to a character that is one position ahead in thealphabet.
            // This is done using modular arithmetic to ensure the result wraps around the alphabet.
            char ch = (char) ((a.charAt(i) - 'a' + 1) % 26 + 'a');
            // Check if the current character in string a matches the current character in string b
            // or if the character with one position ahead matches the character in string b.
            if (a.charAt(i) == b.charAt(j) || ch == b.charAt(j)) {
                j++;  // Move to the next character in string b.
            }
        }
        return j == m;
    }
}