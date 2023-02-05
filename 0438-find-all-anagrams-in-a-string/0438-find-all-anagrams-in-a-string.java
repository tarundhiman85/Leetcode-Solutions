    class Solution {
       public boolean compared(HashMap<Character, Integer> smap, HashMap<Character, Integer> pmap)
    {
        for(Character c : smap.keySet())
        {
            if(pmap.containsKey(c))
            {   if((int)pmap.get(c) != (int)smap.get(c))
                return false;

            }
            else
                return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        HashMap<Character, Integer> pmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();
          for (int i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }
         int start = p.length();
        ArrayList<Integer> res = new ArrayList<>();
          while(start < s.length())
          {
            if(compared(smap, pmap) == true)
            {  
                res.add(start-p.length());
            }
            char arival_char = s.charAt(start);
            smap.put(arival_char,smap.getOrDefault(arival_char,0)+1); 
 // when sliding window moves we need to remove left most character from sliding window
            char removal_char = s.charAt(start -p.length());

            if(smap.get(removal_char) == 1)
                smap.remove(removal_char);
            else
                smap.put(removal_char, smap.get(removal_char) -1);
            // Don't froget to increase start as , it is handling to add new charcter in sliding window and moving it
            start++;
          }
         // at the end last sliding window characters would be left checked , hence checking them also
        if(compared(smap, pmap) == true)
            res.add(start-p.length());


        return res;
    }
}
