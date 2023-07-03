class Solution {
    public boolean buddyStrings(String s, String goal) {
        //Get the length of strings
        int n = s.length();
           // Check if the input strings are the same
        if (s.equals(goal)) {
            // If they are the same, create a set of characters from string 's'
            Set<Character> temp = new HashSet<>();
            for (char c : s.toCharArray()) {
                temp.add(c);
            }
            
            // Return true if the set size is less than the length of 'goal'
            // This means that there are duplicate characters in 's'
            // and swapping any two of them will result in 's' being equal to 'goal'
            return temp.size() < goal.length(); // Swapping same characters
        }
        // Initialize two pointers, 'i' pointing to the start of 's' and 'j' pointing to the end of 's'
        int i = 0;
        int j = n - 1;
        // Find the first index where 's' and 'goal' differ from each other while iterating from the start
        while (i < j && s.charAt(i) == goal.charAt(i)) {
            i++;
        }
         // Find the first index where 's' and 'goal' differ from each other while iterating from the end
        while (j >= 0 && s.charAt(j) == goal.charAt(j)) {
            j--;
        }
        // If there are differing indices, swap the characters at those indices in 's'
        if (i < j) {
            char[] sArr = s.toCharArray();
            char temp = sArr[i];
            sArr[i] = sArr[j];
            sArr[j] = temp;
            s = new String(sArr);
        }
        return s.equals(goal);
    }
}