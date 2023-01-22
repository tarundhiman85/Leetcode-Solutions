class Solution {
     List<List<String>> result = new ArrayList<List<String>>();
    public void solve(List<String> temp, String curr)
    {
        if(curr.length()==0)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < curr.length(); i++) {
            String chk = curr.substring(0, i+1);
            if(isPalindrome(chk))
            {
                temp.add(chk);
                solve(temp, curr.substring(i+1));
                temp.remove(temp.size()-1);
            }
        }
    }
    boolean isPalindrome(String s)
    {
        int i=0,j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {

        solve(new ArrayList<String>(), s);
        return result;
    }
}