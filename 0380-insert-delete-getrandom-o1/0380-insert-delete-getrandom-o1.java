class RandomizedSet {
    
    HashMap<Integer,Integer> hm;
    List<Integer> list;
    
    public RandomizedSet() {
        hm = new HashMap<>();
        list= new ArrayList<>();
    }

    public boolean insert(int val) {
        //In this algo O(1) we insert an item into arrayList and also in map
        if(hm.containsKey(val)) return false;
        list.add(val);
        hm.put(val, list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        //in remove function we first get the number then we swap it with the last number
        if(!hm.containsKey(val))
        {
            return false;
        }
        int ind=hm.get(val);
        Collections.swap(list, ind, list.size()-1);
        int swappedWith = list.get(ind);
        hm.put(swappedWith, ind);
        list.remove(list.size()-1);
        hm.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random r = new Random();
        int rInd = r.nextInt(list.size());
        return list.get(rInd);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */