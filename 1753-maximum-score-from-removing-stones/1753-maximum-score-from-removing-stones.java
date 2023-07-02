class Solution {
    public int maximumScore(int a, int b, int c) {
        //Create a maxheap queue
        PriorityQueue<Integer> maxhp = new PriorityQueue<>((m,n)->n-m);
        //Add all three integers
        maxhp.offer(a);
        maxhp.offer(b);
        maxhp.offer(c);
        //count the score with a healper function
        return countscore(maxhp);
    }

    public int countscore(PriorityQueue<Integer> maxhp){
        int score = 0;
        //If the biggest number is still positive(non-zero)
        while(maxhp.peek()>0){
            //let a be the biggest number
            int a = maxhp.poll();
            //If the second biggest number is still positive(non-zero)
            //Then we are able to perform a removal
            if(maxhp.peek()>0){
                //let b be the second biggest number
                int b = maxhp.poll();
                maxhp.offer(a-1);
                maxhp.offer(b-1);
                score++;
            }
            //If the second biggest number is zero
            //i.e. there is no possible removal anymore
            else break;
        }
        return score;
    }
}