class Solution {
          // Method to calculate the minimum steps to make two strings anagrams
    public int minSteps(String s, String t) {
        // Arrays to store the frequency of each character in the English alphabet
        int[] freqS = new int[26];
        int[] freqT = new int[26];

        // Populate frequency arrays based on characters in strings s and t
        for (int i = 0; i < s.length(); i++) {
            freqS[s.charAt(i) - 'a']++; // Increment the frequency of the current character in string s
            freqT[t.charAt(i) - 'a']++; // Increment the frequency of the current character in string t
        }

        // Variable to store the count of steps needed to make the strings anagrams
        int count = 0;

        // Compare the frequency of each character in t with that in s
        for (int i = 0; i < 26; i++) {
            if (freqT[i] < freqS[i]) {
                // If frequency in t is less than that in s, add the difference to the count
                count += freqS[i] - freqT[i];
            }
        }

        // Return the total count, representing the minimum steps needed
        return count;
    }
    
}