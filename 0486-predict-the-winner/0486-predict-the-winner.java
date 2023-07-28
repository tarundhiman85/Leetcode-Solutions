class Solution {
    // This function calculates the maximum possible score a player can get
    // given a range of elements in the array.
    // i: starting index of the range
    // j: ending index of the range
    // arr: the array containing the numbers
    int f(int i, int j, int[] arr) {
        // Base case: If the starting index is greater than the ending index,
        // the range is invalid, and the score is 0.
        if (i > j)
            return 0;

        // Calculate the maximum score a player can get in this range.
        // The player can either choose the element at index 'i' and face
        // the opponent's best response (min) from the remaining two options,
        // or choose the element at index 'j' and face the opponent's best response (min)
        // from the remaining two options.
        // The player will choose the option that maximizes their score (max).
        return Math.max(arr[i] + Math.min(f(i + 1, j - 1, arr), f(i + 2, j, arr)),
                        arr[j] + Math.min(f(i + 1, j - 1, arr), f(i, j - 2, arr)));
    }

    // This function predicts whether the first player can win the game or not.
    // nums: the array containing the numbers in the game
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        // Calculate the total sum of all the numbers in the array.
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        
        // Calculate the best possible score the first player can achieve by calling 'f' function.
        int bestScore = f(0, n - 1, nums);
        
        // Calculate the other player's score by subtracting the first player's best score from the total sum.
        int otherScore = sum - bestScore;
        
        // Return true if the first player's best score is greater than or equal to the other player's score,
        // indicating that the first player can win or tie the game. Otherwise, return false.
        return bestScore >= otherScore;
    }
}
