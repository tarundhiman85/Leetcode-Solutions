class Solution {
  public int minStoneSum(int[] piles, int k) 
    {
     PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int n = piles.length;
    for(int i=0; i<n; i++){
        pq.add(piles[i]); 
    }
    while(k>0)
     {
        int top = pq.remove();
        top = (int)Math.ceil(top/2.0);
        // System.out.print(top+" ");
        pq.add(top);
        k--;
     }    
     int sum=0;
     while(!pq.isEmpty())
     {
          sum+=pq.remove();
          // System.out.print(sum+" ");
     }
        return sum;
    }
}