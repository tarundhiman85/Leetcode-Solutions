/*
The problem is asking to check whether s2 is scrambled string of s1 or not. The scrambled string of a given string is defined as any string that can be obtained by swapping some characters of the original string. So we can solve this problem recursively by dividing the string into left and right substrings and check for two cases i.e., whether we need to swap the substrings before checking for the next recursive call or not.

Approach
We will first check the base cases i.e., if the two strings are equal or not or if they are of different sizes. Then, we will create a key for the current problem by concatenating the two strings and storing it in a dictionary to avoid repeated computations. We will iterate over all possible splits of the current string and check whether we need to swap the left and right substrings or not. We will then make recursive calls on these two substrings and return true if any of the calls return true.
*/
class Solution {
    // for storing already solved problems
    Map<String, Boolean> mp = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();

        // if both strings are not equal in size
        if (s2.length() != n)
            return false;

        // if both strings are equal
        if (s1.equals(s2))
            return true;

        // if code is reached to this condition then following this are sure:
        // 1. size of both string is equal
        // 2. string are not equal
        // so size is equal (where size==1) and they are not equal then obviously false
        // example 'a' and 'b' size is equal ,string are not equal
        if (n == 1)
            return false;

        String key = s1 + " " + s2;

        // check if this problem has already been solved
        if (mp.containsKey(key))
            return mp.get(key);

        // for every iteration it can two condition
        // 1.we should proceed without swapping
        // 2.we should swap before looking next
        for (int i = 1; i < n; i++) {
            // ex of without swap: gr|eat and rg|eat
            boolean withoutswap = (
                    // left part of first and second string
                    isScramble(s1.substring(0, i), s2.substring(0, i))

                            &&

                            // right part of first and second string;
                            isScramble(s1.substring(i), s2.substring(i))
            );

            // if without swap give us right answer then we do not need
            // to call the recursion withswap
            if (withoutswap) {
                mp.put(key, true);
                return true;
            }

            // ex of withswap: gr|eat rge|at
            // here we compare "gr" with "at" and "eat" with "rge"
            boolean withswap = (
                    // left part of first and right part of second
                    isScramble(s1.substring(0, i), s2.substring(n - i))

                            &&

                            // right part of first and left part of second
                            isScramble(s1.substring(i), s2.substring(0, n - i))
            );

            // if withswap give us right answer then we return true
            // otherwise the for loop do it work
            if (withswap) {
                mp.put(key, true);
                return true;
            }
            // we are not returning false in else case
            // because we want to check further cases with the for loop
        }
        mp.put(key, false);
        return false;
    }
}
