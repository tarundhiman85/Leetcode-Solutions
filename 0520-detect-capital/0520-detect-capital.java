class Solution {
    public boolean detectCapitalUse(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) 
        {
            if(Character.isUpperCase(s.charAt(i)))
            {
                count++;
            }
        }
        if(count==1)
        {
            return Character.isUpperCase(s.charAt(0));
        }
        if(count==len)
        {
            return true;
        }
        return count==0;
    }
}