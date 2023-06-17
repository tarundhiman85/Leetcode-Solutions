class Solution {
    public String longestCommonPrefix(String[] strs) {
        // If the input array is empty, there is no common prefix
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Consider the first string as the initial common prefix
        String prefix = strs[0];
        
        // Iterate through the remaining strings in the array
        for (int i = 1; i < strs.length; i++) {
            // While the current string does not start with the current prefix,
            // we keep removing the last character from the prefix
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If the prefix becomes empty, there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        // Return the final common prefix
        return prefix;
    }
}
