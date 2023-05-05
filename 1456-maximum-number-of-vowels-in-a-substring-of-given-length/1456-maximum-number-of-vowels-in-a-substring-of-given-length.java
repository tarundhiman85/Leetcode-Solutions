class Solution {
    public int maxVowels(String s, int k) {
        int vowelsCount=0;
        
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        for(int i=0; i<k; i++)
        {
            if(set.contains(s.charAt(i)))
            {
                // System.out.print(i+"->"+s.charAt(i)+"->");
                vowelsCount++;
            }
        }
        // System.out.println(vowelsCount);
        int n = s.length();
        int maxCount=vowelsCount;
        for(int i=k; i<n; i++)
        {
            if(set.contains(s.charAt(i-k)))
            {
                vowelsCount--;
            }
            if(set.contains(s.charAt(i)))
            {
                vowelsCount++;
            }
            maxCount=Math.max(maxCount,vowelsCount);
        }
        // System.out.println(n);
        return maxCount;
    }
}