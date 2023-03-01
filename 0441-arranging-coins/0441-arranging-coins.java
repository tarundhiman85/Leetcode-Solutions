class Solution {
  public int arrangeCoins(int n) {
    long left = 0, right = n;
    long k, curr;
    while (left <= right) {
      k = left + (right - left) / 2;
      curr = k * (k + 1) / 2;

      if (curr == n) return (int)k;

      if (n < curr) {
        right = k - 1;
      } else {
        left = k + 1;
      }
    }
    return (int)right;
  }
}
/*
n==5  1 2 2              1       5

n==8  1 2 3 2

n==12 1 2 3 4 2

n==13 1 2 3 4 3

n==16 1 2 3 4 5 1

n==17 1 2 3 4 5 2
*/