class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int ans=0;
        HashMap<Integer, Integer>[] maps = new HashMap[arr.length];
        for(int i=0; i<arr.length; i++)
        {
            maps[i] = new HashMap<>();
        }
        for(int i=1; i<maps.length; i++)
        {
            for(int j=0; j<i; j++)
            {
                //we are getting the common difference
                long cd = (long)arr[i] - (long)arr[j];
                if(cd<=Integer.MIN_VALUE || cd>=Integer.MAX_VALUE)
                {
                    continue;
                }
                int apsEndingOnJ = maps[j].getOrDefault((int)cd, 0);
                int apsEndingOnI = maps[i].getOrDefault((int)cd, 0);
                
                //getting the sum of all A's on J
                ans+=apsEndingOnJ;
                maps[i].put((int)cd, apsEndingOnI+apsEndingOnJ+1);
            }
        }
        return ans;
    }
}