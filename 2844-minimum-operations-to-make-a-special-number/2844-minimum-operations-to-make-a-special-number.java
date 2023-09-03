class Solution {
    private Map<String, Integer> memo = new HashMap<>();

    private int minimumOperationsHelper(String num, int count) {
        String key = num + "_" + count;

        // Check if the result is already memoized
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (num.length() == 1) {
            if (Integer.parseInt(num) != 0) {
                memo.put(key, count + 1);
                return count + 1;
            } else {
                memo.put(key, count);
                return count;
            }
        }

        if (num.length() >= 2) {
            String lastTwoDigits = num.substring(num.length() - 2);
            int lastTwoNum = Integer.parseInt(lastTwoDigits);
            if (lastTwoNum % 25 != 0) {
                int option1 = minimumOperationsHelper(num.substring(0, num.length() - 1), count + 1);
                int option2 = minimumOperationsHelper(num.substring(0, num.length() - 2), count + 2);
                char last = num.charAt(num.length() - 1);
                int option3 = minimumOperationsHelper(num.substring(0, num.length() - 2) + last, count + 1);
                int minCount = Math.min(option1, Math.min(option2, option3));
                memo.put(key, minCount);
                return minCount;
            }
        }

        memo.put(key, count);
        return count;
    }
    public int minimumOperations(String num) 
    {           
        return minimumOperationsHelper(num, 0);
    }
}