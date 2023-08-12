class Solution {
    
    List<String> ans;
    public void f(String oS, String s, List<String> wordDict, String str)
    {
        //call a function which temporary removes whitespace and check equals then put in list
       if(s.length()==0 && isStringEqual(str, oS))
       {
           ans.add(str.trim());
           return;
       }
       for(String word : wordDict)
       {
           if(s.startsWith(word))
           {
               f(oS, s.substring(word.length()), wordDict, str + word + " ");
           }
       }
    }
    public static boolean isStringEqual(String str, String oS) {
        str = str.replaceAll("\\s+", "");
        return str.equals(oS);
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        f(s, s, wordDict, "");
        return ans;
    }
}