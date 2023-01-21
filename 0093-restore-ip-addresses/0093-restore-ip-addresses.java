class Solution {
      public void backtrack(String s, int i, int dots, String currIp, List<String> res) {
        if (dots == 4 && i == s.length()) {
            res.add(currIp.substring(0, currIp.length() - 1));
            return;
        }
        if (dots > 4) return;

        for (int j = i; j < Math.min(i+3, s.length()); j++) {
            //we can take upto 3 digits in minimum way and digits must be less then 256 and if it is more then two digits then it must be not 0
            if (Integer.parseInt(s.substring(i, j+1)) < 256 && (i == j || s.charAt(i) != '0')) {
                backtrack(s, j+1, dots+1, currIp + s.substring(i, j+1) + ".", res);
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12) return res;

        backtrack(s, 0, 0, "", res);
        return res;
    }
}