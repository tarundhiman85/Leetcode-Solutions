class Solution {
    public int minimumSum(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 1;

        int len = 0;
        int sum = 0;
        while(len < n)
        {
            boolean skip = false;
            for(Integer el : arr)
            {
                if(el + i == k)
                {
                    skip = true;
                }
                if(skip)
                {
                    break;
                }
            }
            if(!skip)
            {
                arr.add(i);
                sum += i;
                len++;
            }
            i++;
        }
        //System.out.println(arr);
        return sum;
    }
}