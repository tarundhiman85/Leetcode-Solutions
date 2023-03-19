class WordDictionary {
  class TrieNode {
    boolean isWord;
    TrieNode[] children;
    
    public TrieNode() {
      isWord = false;
      children = new TrieNode[26];
    }
  }
  
  TrieNode root;

  public WordDictionary() {
    root = new TrieNode();
  }

  /**
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   */
  public void addWord(String word) {
    TrieNode node = root;
    /**
     * Time Complexity: O(n)
     *   - word length
     * Space Complexity: O(n)
     *   - word length
     */
    for (int i = 0; i < word.length(); i++) {
      int idx = word.charAt(i) - 'a';
      if (node.children[idx] == null) {
        /**
         * Space Complexity: O(1)
         *   - Always 26 lower-case English letters
         */
        node.children[idx] = new TrieNode();
      }
      node = node.children[idx];
    }
    node.isWord = true;
  }


  /**
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   */
  public boolean searching(String word, TrieNode node, int wordIdx) {
    if (node == null) return false;
    /**
     * Time Complexity: O(n)
     *   - word length
     */
    for (int i = wordIdx; i < word.length(); i++) {
      int idx = word.charAt(i) - 'a';
      // ('.' - 'a') = -51
      if (idx == (-51)) {
        /**
         * Time Complexity: O(1)
         *   - Always 26 lower-case English letters
         */
        for (int j = 0; j < node.children.length; j++) {
          /**
           * Space Complexity: O(n)
           *   - stack: if search '.' for whole letters.
           */
          if (searching(word, node.children[j], i + 1)) {
            return true;
          }
        }
        return false;
      }
      if (node.children[idx] == null) return false;
      node = node.children[idx];
    }
    return node.isWord;
  }

  public boolean search(String word) {
    return searching(word, root, 0);
  }
}