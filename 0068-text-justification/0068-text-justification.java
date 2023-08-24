import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>(); // Initialize the result list
        
        for (int i = 0, wordCount, lineLength; i < words.length; i += wordCount) {
            // Find the number of words that can fit in the current line and their total length
            for (wordCount = 0, lineLength = 0; 
                 i + wordCount < words.length && 
                 lineLength + words[i + wordCount].length() + wordCount <= maxWidth; 
                 wordCount++)
            {
                lineLength += words[i + wordCount].length();
            }
            
            StringBuilder lineBuilder = new StringBuilder(words[i]); // Initialize line with the first word
            
            if (wordCount == 1 || i + wordCount == words.length) {
                // Left justify if only one word or at the last line
                for (int j = 1; j < wordCount; j++) {
                    lineBuilder.append(" ").append(words[i + j]);
                }
                lineBuilder.append(" ".repeat(maxWidth - lineBuilder.length())); // Add remaining spaces
            } else {
                int totalSpaces = (maxWidth - lineLength) / (wordCount - 1); // Calculate spaces between words
                int extraSpaces = (maxWidth - lineLength) % (wordCount - 1); // Calculate extra spaces
                
                // Distribute spaces between words
                for (int j = 1; j < wordCount; j++) {
                    int spacesToAdd = totalSpaces + (extraSpaces-- > 0 ? 1 : 0);
                    lineBuilder.append(" ".repeat(spacesToAdd)).append(words[i + j]);
                }
            } 
            result.add(lineBuilder.toString()); // Add the fully justified line to the result list
        }   
        return result; // Return the list of justified lines
    }
}
