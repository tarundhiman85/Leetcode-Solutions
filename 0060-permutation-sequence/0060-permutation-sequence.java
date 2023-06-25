class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1; // initialize a variable to store the factorial of n

        List<Integer> numbers = new ArrayList<>(); // create a list to store the numbers from 1 to n

        // calculate the factorial of n and add numbers from 1 to n to the list
        for(int i = 1; i < n; i++){
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);

        String ans = ""; // initialize an empty string to store the answer

        k = k - 1; // since indexing starts from 0, subtract 1 from k
        //loop until all numbers have been used
        while(true)
        {
            ans = ans + numbers.get(k/fact); //add the number at index k/fact to the answer
            numbers.remove(k/fact); //remove the used number from the list
            //if all numbers have been used, break out of the loop
            if(numbers.size()==0)
            {
                break;
            }
            k = k % fact; //calculate the remainder of k/fact and assign it to k
            fact = fact / numbers.size();
        }
        return ans;
    }
}