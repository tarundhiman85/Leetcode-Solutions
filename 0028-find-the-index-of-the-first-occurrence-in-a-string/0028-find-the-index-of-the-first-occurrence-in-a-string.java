class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int len = needle.length();
        for(int i=0; i<=n-len; i++)
        {
            if(haystack.charAt(i)==needle.charAt(0) && haystack.substring(i,i+len).equals(needle))
            {
                return i;
            }
        }
        return -1;
    }
}