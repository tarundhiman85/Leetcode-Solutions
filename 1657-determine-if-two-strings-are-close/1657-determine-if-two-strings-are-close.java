class Solution {
    public boolean closeStrings(String word1, String word2) {
         //count the frequency of each word in word1 and word2
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }
        //check if the frequency of each word in word1 and word2 is the same
        for (int i = 0; i < 26; i++) {
            if (count1[i] == 0 && count2[i] != 0 || count1[i] != 0 && count2[i] == 0) {
                return false;
            }
        }
        //sort the frequency of each word in word1 and word2
        Arrays.sort(count1);
        Arrays.sort(count2);
        //check if the frequency of each word in word1 and word2 is the same
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}