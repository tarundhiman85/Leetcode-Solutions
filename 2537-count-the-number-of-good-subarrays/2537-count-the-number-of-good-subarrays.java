class Solution {
    public long countGood(int[] arr, int k) {
        int n = arr.length;
        //It counts each and every occurance of number
        Map<Integer, Integer> m = new HashMap<>();
        long pairs = 0;
        int j = 0;
        long ans = 0;
        //credit goes to newton school for eplanation in FUTURE
        for(int i=0; i<n; i++)
        {
            //find first index for every index which satisfies arr[i]==arr[j]  and i<j which gives k pairs
            while(pairs<k && j<n)
            {
                if(m.get(arr[j])==null)
                {
                    //if the element is not in the map
                    m.put(arr[j], 1);
                }
                else{
                    //pairs will increase by the previous count
                    pairs += m.get(arr[j]);
                    //if the element again happens
                    m.put(arr[j], m.getOrDefault(arr[j], 0)+1);
                    //now we will increase the pairs which happens due to that pairs
                }
                j++;
            }
            if(pairs>=k)
            {
               //j-1 is the index because j++ happens on the while loop after pairs>=k
                ans += (n-(j-1));
            }
            //reduce the counting which is coming due to i
            m.put(arr[i], m.get(arr[i])-1);
            //also reduce the pairs which is happening due to pairs i
            pairs -= m.get(arr[i]);
        }
        return ans;
    }
}