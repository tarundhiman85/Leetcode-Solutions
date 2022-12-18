class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] output = new int[n];
        if(n==0) return output;
        for(int i=0; i<n; i++)
        {
            while(!st.isEmpty() && arr[st.peek()]<arr[i])
            {
                int popped = st.pop();
                output[popped] = i - popped;
            }
            st.push(i);
        }
        return output;
    }
}