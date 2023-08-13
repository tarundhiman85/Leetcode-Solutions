import java.util.HashMap;

class Solution {
    public int countSubstrings(String s, String t) {
        // Create HashMaps to store the values for substrings ending at each (sdx, tdx) pair
        // Z stores the count of substrings with 0 different characters
        // O stores the count of substrings with 1 different character
        HashMap<Pair<Integer, Integer>, Integer> Z = new HashMap<>();
        HashMap<Pair<Integer, Integer>, Integer> O = new HashMap<>();
        
        // Iterate through the strings in reverse order
        for (int sdx = s.length() - 1; sdx >= 0; sdx--) {
            for (int tdx = t.length() - 1; tdx >= 0; tdx--) {
                if (s.charAt(sdx) == t.charAt(tdx)) {
                    // Substrings with 0 differences increase the count in Z
                    Z.put(new Pair<>(sdx, tdx), 1 + Z.getOrDefault(new Pair<>(sdx + 1, tdx + 1), 0));
                    O.put(new Pair<>(sdx, tdx), O.getOrDefault(new Pair<>(sdx + 1, tdx + 1), 0));
                } else {
                    // Substrings with 1 difference increase the count in O
                    O.put(new Pair<>(sdx, tdx), 1 + Z.getOrDefault(new Pair<>(sdx + 1, tdx + 1), 0));
                }
            }
        }
        
        // Sum up the values in the O HashMap to get the total count of substrings
        int totalCount = 0;
        for (int count : O.values()) {
            totalCount += count;
        }
        
        return totalCount;
    }
}
