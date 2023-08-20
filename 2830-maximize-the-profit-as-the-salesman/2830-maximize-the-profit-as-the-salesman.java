class Solution {
   public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        // Sort offers based on their end time
        Collections.sort(offers, (a, b) -> Integer.compare(a.get(1), b.get(1)));

        // Create a TreeMap to store maximum profit for each end time
        TreeMap<Integer, Integer> maxDP = new TreeMap<>();
        maxDP.put(-1, 0); // Initialize with base case

        for (List<Integer> each : offers) {
            int currentStart = each.get(0);
            int currentEnd = each.get(1);
            int currentProfit = each.get(2);

            // Find the maximum profit before the current offer's start time
            Integer maxProfitBeforeThisStart = maxDP.floorEntry(currentStart - 1).getValue();
            //The condition profitWhenWeDo > maxDP.lastEntry().getValue() checks whether considering the current offer results in a higher
            // profit than what has been achieved so far. If it does, it means that adding the current offer would lead to a better 
            // solution, so it's worth updating the maxDP TreeMap with this new higher profit.

            //If the condition is true, maxDP.put(currentEnd, profitWhenWeDo) updates the TreeMap with the new profit. The key currentEnd 
            // represents the end time of the current offer, and the value is set to the profitWhenWeDo.
            if (maxProfitBeforeThisStart != null) {
                int profitWhenWeDo = maxProfitBeforeThisStart + currentProfit;

                // Update maxDP with the new profit if it's greater than the current maximum
                if (profitWhenWeDo > maxDP.lastEntry().getValue()) {
                    maxDP.put(currentEnd, profitWhenWeDo);
                }
            }
        }

        // Return the maximum profit found in the TreeMap
        return maxDP.lastEntry().getValue();
    }
}