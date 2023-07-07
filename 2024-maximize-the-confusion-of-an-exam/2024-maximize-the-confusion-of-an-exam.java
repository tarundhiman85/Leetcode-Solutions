class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
      int maxFreq = 0; //Maximum frequency of a character in a substring
      int i = 0 ; //start index of current substring
      Map<Character, Integer> charCount = new HashMap<>(); //Map to track character frequencies
      //Iterate through the answerKey String
      for(int j = 0; j < answerKey.length(); j++)
      {
          char currentChar = answerKey.charAt(j);
          
          //Update the character count in map
          charCount.put(currentChar, charCount.getOrDefault(currentChar, 0)+1);
          
          //Update the maximum frequency
          maxFreq = Math.max(maxFreq, charCount.get(currentChar));
          
          //If the length of the current substring is larger then the maximum frequency plus k,
          //we need to  move the start index(i. shrink the window)
          if(j - i + 1 > maxFreq + k)
          {
              charCount.put(answerKey.charAt(i), charCount.get(answerKey.charAt(i))-1);
              i++;
          }
      }
        return answerKey.length() - i;
    }
}