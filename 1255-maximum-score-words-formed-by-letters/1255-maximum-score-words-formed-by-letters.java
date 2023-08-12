class Solution {
public boolean isPossible(int[] freq, char[] word) {
    for (char c : word) {
        if (freq[c - 'a'] == 0) {
            return false;
        }
        if (freq[c - 'a'] < countOccurrences(word, c)) {
            return false;
        }
    }
    return true;
}

private int countOccurrences(char[] word, char target) {
    int count = 0;
    for (char c : word) {
        if (c == target) {
            count++;
        }
    }
    return count;
}

    public int f(String[] words, int[] freq, int[] score, int idx)
    {
        if (idx >= words.length)
        {
            return 0;
        }
        int take = 0;
        int notTake = 0;
        if(isPossible(freq, words[idx].toCharArray()))
        {
            int sum = 0;
            for(int i=0; i<words[idx].length(); i++)
            {
                freq[words[idx].charAt(i) - 'a']--;
                sum += score[words[idx].charAt(i)-'a'];
            }
            take = sum + f(words, freq, score, idx + 1);
            for(int i=0; i<words[idx].length(); i++)
            {
                freq[words[idx].charAt(i) - 'a']++;
                sum -= score[words[idx].charAt(i)-'a'];
            }
        }
        notTake = f(words, freq, score, idx + 1);
        return Math.max(take, notTake);
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int letLen = letters.length;
        int[] freq = new int[26];
        for(int i=0; i<letLen; i++)
        {
            freq[letters[i]-'a']++;
        }
        return f(words, freq, score, 0);
    }
}