class Solution {
    public boolean isAcronym(List<String> words, String s) {
        int n = s.length();
        String res = "";
        for(String word : words)
        {
            res += word.charAt(0);
        }
        return res.equals(s);
    }
}