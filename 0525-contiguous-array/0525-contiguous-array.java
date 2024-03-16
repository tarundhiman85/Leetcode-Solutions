class Solution {
    public int findMaxLength(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(arr[i]==0){
                arr[i]=-1;
            }
        }
        Map<Integer,Integer> m  = new HashMap<>();
        int sum=0;
        int maxLen=0;
        for(int i=0; i<n; i++){
           sum+=arr[i];
                if(sum==0){
                    if(maxLen<i+1){
                        maxLen=i+1;
                    }
                }
                else if(!m.containsKey(sum)){
                    m.put(sum,i);
                }
                else{
                    if(maxLen<(i-m.get(sum))){
                        maxLen=i-m.get(sum);
                    }
                }
            }
        
        return maxLen;
    }
}