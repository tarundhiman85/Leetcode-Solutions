class LFUCache {

    int cap;
    Map<Integer,Integer> cache = new HashMap<>();
    Map<Integer,Integer> keycount = new HashMap<>();
    Map<Integer,LinkedHashSet<Integer>> freqmap = new HashMap<>();
    int min = -1;
    public LFUCache(int capacity) {
        cap = capacity;
        freqmap.put(1,new LinkedHashSet<>());  //initially key 1 is the minimum frequency
    }

    public int get(int key) {
        if(cache.containsKey(key)==false) //if key is not present in cache
            return -1;
        int count = keycount.get(key); //get the count of the key
        keycount.put(key,count+1);  //increment the count of the key as it is accessed
        freqmap.get(count).remove(key);  //remove the key from the set of count as it is accessed so it should be moved to next set
        if(count==min&&freqmap.get(count).size()==0)  //if the count is minimum and the set of that count is empty then increment the minimum count
            min++;  //increment the minimum count
        if(freqmap.containsKey(count+1)==false)  //if the set of count+1 is not present then create a new set
            freqmap.put(count+1,new LinkedHashSet<>());  //create a new set for count+1
        freqmap.get(count+1).add(key);  //add the key to the set of count+1
        return cache.get(key);
    }

    public void put(int key, int value) {
        if(cap<=0)                //if capacity is 0, then return
            return;
        if(cache.containsKey(key))  //if key is already present, then update the value and return
        {
            cache.put(key,value);
            get(key);
            return;
        }
        if(cache.size()>=cap)  //if cache is full, then remove the least frequently used key
        {
            int evict = freqmap.get(min).iterator().next(); //get the least frequently used key by getting the first element of the set of minimum count
            freqmap.get(min).remove(evict); //remove the key from the set of minimum count
            cache.remove(evict); //remove the key from the cache
            keycount.remove(evict); //remove the key from the keycount map
        }
        cache.put(key,value);  //put the new key in the cache
        keycount.put(key,1);  //put the new key in the keycount map with frequency 1
        min = 1;              //update the minimum frequency  because new key is added
        freqmap.get(1).add(key);  //add the new key to the frequency map LinkedHashSet
}

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */