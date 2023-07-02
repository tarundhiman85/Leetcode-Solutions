class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<gifts.length; i++)
        {
            pq.add(gifts[i]);
        }
        for(int i=0; i<k; i++)
        {
            int element = pq.poll();
            if(element>0)
            {
                int newElem =(int) Math.sqrt(element);
                pq.add(newElem);
            }
        }
        long sum = 0;
        while(!pq.isEmpty())
        {
            sum+=pq.poll();
        }
        return sum;
    }
}