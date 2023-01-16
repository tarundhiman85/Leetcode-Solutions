class Solution {
    public int[][] insert(int[][] ints, int[] newInt) {
        // if no intervals present 
        if(ints.length == 0)return new int[][]{newInt};
        
        int n = ints.length;
        List<int[]> list = new ArrayList<>();
        
        //comparator to search the insertion point of the given interval in a sorted interval;
        Comparator<int[]> comp = new Comparator<int[]>(){
            public int compare(int[] a , int[] b){
                return a[0] == b[0]?a[1]-b[1] :a[0]-b[0];
            }
        };
        // ip  is the insertion point of the interval in the arrray if same interval is already present no need to insert new one
        int ip = Arrays.binarySearch(ints , newInt , comp);
        if(ip >= 0)return ints;
        
        ip = -ip-1;// binarySearch return -(inpt+1);
        // System.out.println(ip);
        
        //make a merged interval
        int[] mi = new int[2];
        
        //set the starting pt of merged interval
        if(ip == 0){// [i<=1,0] && [1,3] 
            mi[0] = newInt[0];
        }else{
            if(ints[ip-1][1] >= newInt[0])mi[0] = Math.min(ints[ip-1][0],newInt[0]);
            else mi[0] = newInt[0];
        }
        
        //while some interval starts before the interval ends then we merge it
        while(ip < n && ints[ip][0] <= newInt[1])ip++;
        
        //set the end pt of merged interval
        if(ip != 0){
            mi[1] = Math.max(newInt[1] , ints[ip-1][1]);
        }else{
            mi[1] = newInt[1];
        }
        
        //iterate and add all the intervals that end or start before mi
        int it = 0;
        for(; it < n && ints[it][0] < mi[0] ; it++){
            list.add(ints[it]);
        }
        list.add(mi);//add merged interval 
        //add all the interval that start after the end merged interval
        while(it < n && ints[it][1] <= mi[1])it++;
        while(it < n){
            list.add(ints[it]);it++;
        }
        //return the list as array
        return list.toArray(new int[0][]);
    }
}
/*

1 2 3    
          6 7 8 9
  2 3 4 5 

1       5 6     9

for two intervals
   if they are overlapping we need lowest value and highest value
*/