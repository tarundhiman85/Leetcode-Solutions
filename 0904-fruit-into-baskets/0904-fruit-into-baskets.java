class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if(n==1) return 1;
        Map<Integer, Integer> m = new HashMap<>();
        int i=0;
        int j=0;
        int max = 0;
        while(j<n)
        {
            m.put(fruits[j], m.getOrDefault(fruits[j],0)+1);
            if(m.size()==2)
            {
                int currentValue = 0;
                for(var entry: m.entrySet())
                {
                    currentValue += entry.getValue();
                }
                max = Math.max(max, currentValue);
            }
            else if(m.size()>2)
            {
                int ithCount = m.get(fruits[i]);
                ithCount--;
                m.put(fruits[i], ithCount);
                if(ithCount==0)
                {
                    m.remove(fruits[i]);
                }
                i++;
            }
            j++;
        }
        if(max==0){
            int currentValue = 0;
            for(var entry: m.entrySet())
            {
                currentValue += entry.getValue();
            } 
            return currentValue;
        }
        return max;
    }
}
/*
[0,1,2,2]

0 - 1
1 - 1
2 - 1

while moving to right make sure to select 2 fruits with max count possible
             if moving right cant
             
in variable size sliding window we check condition[here map size of two]
      if condition met then we take max of sum of values of numbers        

*/