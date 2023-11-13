class Solution {
    private static boolean Vowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
    public String sortVowels(String str) {
        int n = str.length();
        StringBuilder vowels = new StringBuilder();
        for(int i=0; i<n; i++)
        {
            if(Vowel(str.charAt(i)))
            {
                vowels.append(str.charAt(i));
            }
        }
        char[] result = str.toCharArray();
        char[] vowelsArray = vowels.toString().toCharArray();
        Arrays.sort(vowelsArray);
        int resultPointer = 0;
        int vowelsPointer = 0;

    // Iterate through the result array and replace each vowel with the vowel from the vowels array
    while (resultPointer < n) {
        if (Vowel(result[resultPointer])) {
            result[resultPointer] = vowelsArray[vowelsPointer];
            vowelsPointer++;
        }
        resultPointer++;
    }

    return new String(result);
    }
}