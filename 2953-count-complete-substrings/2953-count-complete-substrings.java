class Solution {
    public boolean isEqual(int[] arr, int k) {
            for (int count : arr) {
                if (count != 0 && count != k) {
                    return false;
                }
            }
            return true;
        }

        // Method to check if characters in the substring are adjacent based on a condition
        public boolean isAdjacent(String w, int s, int e) {
            for (int i = s; i < e; i++) {
                if (Math.abs(w.charAt(i) - w.charAt(i + 1)) > 2) {
                    return false;
                }
            }
            return true;
        }

        // Method to count complete substrings with a specific property
        public int countCompleteSubstrings(String word, int k) {
            // Count total unique characters in the input word
            int totalUniqueChars = (int) word.chars().distinct().count();
            int count = 0;

            // Iterate through different counts of unique characters
            for (int uniqueChars = 1; uniqueChars <= totalUniqueChars; uniqueChars++) {
                // Calculate the size of the window based on unique characters and k
                int windowSize = uniqueChars * k;
                if (windowSize > word.length()) {
                    break; // Break if the window size exceeds the word length
                }

                // Array to count occurrences of characters in the window
                int[] charToCount = new int[26];
                for (int i = 0; i < windowSize; i++) {
                    charToCount[word.charAt(i) - 'a']++;
                }

                // Check if the counts in the window are equal to k and characters are adjacent
                if (isEqual(charToCount, k) && isAdjacent(word, 0, windowSize - 1)) {
                    count++; // Increment count if conditions are met for the initial window
                }

                // Move the window and recheck for subsequent substrings
                for (int start = 1; start <= word.length() - windowSize; start++) {
                    // Update character counts for the sliding window
                    charToCount[word.charAt(start - 1) - 'a']--;
                    charToCount[word.charAt(start + windowSize - 1) - 'a']++;

                    // Check if conditions are met for the new window position
                    if (isEqual(charToCount, k) && isAdjacent(word, start, start + windowSize - 1)) {
                        count++; // Increment count if conditions are met for the new window
                    }
                }
            }

            return count; // Return the total count of complete substrings
}
}