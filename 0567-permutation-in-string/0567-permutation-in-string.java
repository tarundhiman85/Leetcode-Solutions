class Solution {
    /*
    abcefabcdg
         abcd
         
    cebafacbdg
        x     
    abcd
    
    dcda
    adc
    
    ooolleoooleh
           hello
    
    reduce occurance and if 0 then remove entry and we slide the window
    */
       public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s1.length(); i++)
        {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0)+1);
        }
        int n = s2.length();
        int m = s1.length();
        int i=0;
        int start = i;
        Map<Character, Integer> temp = new HashMap<>();
        while(i<n)
        {
            if(map.containsKey(s2.charAt(i)) && (i-start+1)<=m)
            {
                temp.put(s2.charAt(i), temp.getOrDefault(s2.charAt(i), 0)+1);
                i++;
                // count++;
            }
            else if(temp.equals(map))
            {
                return true;
            }
            else if(i-start+1>m)
            {
                temp.put(s2.charAt(start), temp.get(s2.charAt(start))-1);
                if(temp.get(s2.charAt(start))==0) temp.remove(s2.charAt(start));
                start++;
            }
            else{
                temp = new HashMap<>();
                i++;
                start=i;
            }
        }
        return temp.equals(map);
    }
}