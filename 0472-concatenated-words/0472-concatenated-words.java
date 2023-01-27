   class Solution {
     class Trie {
        Map<Character, Trie> character = new HashMap<>();
        boolean isLeaf = false;
        int count = 0;
    }

    public void insert(Trie root, String str) {
        Trie curr = root;
        for (char ch : str.toCharArray()) {
            if (curr.character.get(ch) == null) {
                curr.count++;
                curr.character.put(ch, new Trie());
            }
            curr = curr.character.get(ch);
        }
        curr.isLeaf = true;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words)
    {
        Trie root = new Trie();
        for(String word : words)
        {
            insert(root,word);
        }
        List<String> ans = new ArrayList<>();
        for (String word: words) {
            if(dfs(root, word,0,0))
            {
                ans.add(word);
            }
        }
        return ans;
    }
    boolean dfs(Trie root, String key, int index, int count)
    {
        if(index>=key.length())
        {
            //if we moved greater then the word length then it simply means we have traversed the whole word we need to check if count>1
            return count>1;
        }
        //we traverse the string from index to key length
        Trie curr = root;
        for (int i = index; i < key.length(); i++) {
            char ch = key.charAt(i);
            //for the current character check if we have entry in trie
            if(!curr.character.containsKey(ch))
            {
                return false;
            }
            //we iterate till we are getting same
            curr = curr.character.get(ch);
            if(curr.isLeaf)
            {
                //if we are gone to leaf node then it means we have gone to the end of word
                //then we need to make sure for the again starting from the root trie it's count>1
                if(dfs(root, key, i+1, count+1))
                {
                    return true;
                }
            }
        }
        return false;
    }

}