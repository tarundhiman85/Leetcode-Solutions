class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] output = new int[arr.length];
        if(arr.length==0) return output;

       for(int i=arr.length-1; i>=0; i--){
           while(!st.isEmpty() && arr[i]>=arr[st.peek()]){
               st.pop();  //we will get the last element
               //we will place
           }
           if(!st.isEmpty() && arr[i]<arr[st.peek()]){
               //we will check if the element is hotter then put that element to the result
               //by calculating the distance
               int distance=st.peek()-i;
               output[i]=distance;
           }
           st.push(i);
       }
       return output;
    }
}