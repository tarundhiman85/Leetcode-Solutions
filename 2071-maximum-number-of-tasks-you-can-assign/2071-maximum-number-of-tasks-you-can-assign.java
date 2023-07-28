class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : workers)
        	map.put(i, map.getOrDefault(i, 0) + 1);
        int res = 0, left = 0, right = Math.min(tasks.length, workers.length) - 1; 
        while (left <= right) {
        	int mid = (left + right) / 2;
        	if (validate(tasks, (TreeMap<Integer, Integer>)map.clone(), pills, strength, mid))
        		res = left = mid + 1;
        	else
        		right = mid - 1;
        }
        return res;
    }
    boolean validate(int[] tasks, TreeMap<Integer, Integer> map, int pills, int strength, int pos) {
    	for (; pos >= 0; pos--) {
	    	int maxStrength = map.lastKey(), t = tasks[pos];
	    	if (pills > 0 && strength + maxStrength < t || pills == 0 && maxStrength < t)
	    		return false;
	    	if (maxStrength < t) {
	    		t -= strength;
	    		pills--;
	    	}
    		int matchStrength = map.ceilingKey(t);
    		if (map.get(matchStrength) > 1)
    			map.put(matchStrength, map.get(matchStrength) - 1);
    		else
    			map.remove(matchStrength);
    	}
    	return true;
    }
}