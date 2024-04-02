class Solution {
    public boolean isIsomorphic(String s, String t) {
    if(s.length() != t.length()){
    return false;
    }
    HashMap<Character,Character> h = new HashMap<>();
    for(int i=0;i<s.length();i++){
        
    if(!h.containsKey(s.charAt(i)))
    {
    if(!h.values().contains(t.charAt(i)))
    {h.put(s.charAt(i),t.charAt(i));
    }
    else
    return false;
    }
    }

    for(int i=0;i<s.length();i++){
        if(h.get(s.charAt(i)) == t.charAt(i))
            continue;
        else
            return false;
    }
    return true;
}      
}