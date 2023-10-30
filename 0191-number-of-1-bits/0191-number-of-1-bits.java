public class Solution {   
    public int hammingWeight(int num) {
       int weight = 0;
        
         while (num != 0) {
            weight++;
            num &= (num - 1);
        }
        
        return weight;
    }
}