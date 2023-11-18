class Solution {
    public List<Integer> findLonely(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i : arr) map.put(i, map.getOrDefault(i, 0) + 1);
        for (int i : arr) if (map.get(i) == 1 && !map.containsKey(i - 1) && !map.containsKey(i + 1)) list.add(i);
        return list;
    }
}