class Solution {
public String largestOddNumber(String num) {
    int n = num.length();
    char[] arr = num.toCharArray();
    int j = -1;
    for (int i = n - 1; i >= 0; i--) {
        if (Character.isDigit(arr[i]) && Integer.parseInt(String.valueOf(arr[i])) % 2 != 0) {
            j = i;
            break;
        }
    }
    if (j != -1) {
        return num.substring(0, j + 1);
    }
    return "";
}

}