class Solution {
    public int bestClosingTime(String cust) {
        //get the length of input string
        int len = cust.length();
        
        //Arrays to store counts of 'N' and 'Y' characters encountered
        int[] n = new int[len+1];
        int[] y = new int[len+1];
        
        int cc = 0; // counter for 'Y' characters
        
        //Calculate the count of 'Y' characters for each index in reverse order
        for(int i= len - 1; i>=0; i--)
        {
            if(cust.charAt(i) == 'Y')
            {
                cc++;  //Increment the 'Y' character count
            }
            y[i] = cc; //store the 'Y' count at corresponding index
        }
        
        int nc = 0; //counter for 'N' characters
        
        //calculate the count of 'N' characters for each index
        for(int i=0; i<len; i++)
        {
           if (cust.charAt(i) == 'N') {
            nc++; // Increment 'N' character count
           }
            n[i + 1] = nc; // Store the 'N' count at the next index 
        }
        
        int MIN = Integer.MAX_VALUE; // Initialize minimum sum of 'Y' and 'N' counts
        int idx = 0;  //index corresponding to the minimum sum
        
        // Iterate through the arrays to find the index with the minimum sum
        for(int i=0; i < len + 1; i++)
        {
            if(y[i] + n[i] < MIN)
            {
                MIN = y[i] + n[i];  //update the min sum;
                idx = i; //update the corresponding index
            }
        }
        return idx;  //Return the index with the best closing time
    }
}