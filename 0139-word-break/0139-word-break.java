class Solution {

    boolean check=false;
    
    HashMap<String, Boolean> dp = new HashMap<>();
    
    boolean solve(String s, List<String> wordDict){
        if(s.length()==0) return true;
        if(dp.containsKey(s)) return dp.get(s);
        
        for(String word : wordDict){
            if(s.startsWith(word)){
                check = check || solve(s.substring(word.length()), wordDict);
            }
        }
        dp.put(s, check);
        return dp.get(s);
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(s, wordDict);
    }
}
/*

f(i):
 if(i >= n):
   return true
 for j in range(wd.length):
    if s[i] == wd[j][0] && wd[j].length <= s.substr(i) && wd[j] == s.substr(i, wd[j].length):
        return f(i + wd[j].length)
 return false  
*/