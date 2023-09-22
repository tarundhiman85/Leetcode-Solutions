class Solution {
    public boolean isSubsequence(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int i = s.length-1;
        int j = t.length-1;
        while(i>-1 && j>-1){
            if(s[i]==t[j]){
                i--;
                j--;
            }
            else{
                j--;
            }
        }
        return i==-1;
    }
}