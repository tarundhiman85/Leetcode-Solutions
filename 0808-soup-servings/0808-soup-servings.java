class Solution {
     // HashMap to store computed results for a pair of (a, b) values
    // The Pair<Integer, Integer> class will be used as the key, and the computed result (Double) will be the value.
    private HashMap<Pair<Integer, Integer>, Double> memo = new HashMap<>();
    public double soupServings(int N) {
        //if N is greater then 4800, the probability is 1 because probability of reaching 0 from any value is 1
        if(N > 4800)
        {
            return 1.0;
        }
        //Divide N by 25, as the recipe serves soup in multiple of 25
        N = (N + 24) / 25;
        //Start the dp recursion from the initial state
        return dp(N,N);
    }
    private double dp(int a, int b)
    {
           // Base cases:
        // If both a and b are non-positive (<= 0), it means both soups are finished. Return 0.5 as it's half of the probability.
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        
        // If a is non-positive (<= 0) but b is positive, it means soup A is finished, and B still has some servings.
        // In this case, we return 1.0 as the probability of finishing A is 1.0.
        if (a <= 0) {
            return 1.0;
        }
          // If b is non-positive (<= 0) but a is positive, it means soup B is finished, and A still has some servings.
        // In this case, we return 0.0 as the probability of finishing B is 0.0.
        if (b <= 0) {
            return 0.0;
        }
        // If the current (a, b) pair is already computed and stored in the 'memo' HashMap, return the precomputed value.
        Pair<Integer, Integer> key = new Pair<>(a, b);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // If the result for the current (a, b) pair is not yet computed, calculate it using the recursive formula:
        // probability(a, b) = 0.25 * (probability(a-4, b) + probability(a-3, b-1) + probability(a-2, b-2) + probability(a-1, b-3))
        double probability = 0.25 * (dp(a - 4, b) + dp(a - 3, b - 1) + dp(a - 2, b - 2) + dp(a - 1, b - 3));
        // Store the computed probability in the 'memo' HashMap for future reference.
        memo.put(key, probability);
        
        // Return the computed probability for the current (a, b) pair.
        return probability;
    }
}