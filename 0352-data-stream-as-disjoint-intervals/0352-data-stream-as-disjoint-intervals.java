class SummaryRanges {
    // the overall idea is to see if it is adjacent diff of 1
    TreeSet<Integer> values;
    public SummaryRanges() {
        values = new TreeSet<>();
    }
    
    public void addNum(int value) {
        values.add(value);
    }
    
    public int[][] getIntervals() {
         if (values.isEmpty()) {
            return new int[0][2];
        }
        int left = -1;
        int right = -1;
        List<int[]> intervals = new ArrayList<>();
        for(Integer val : values)
        {
            if(left<0)
            {
                //if we don't have any lower bound then simply make new lower bound
                left = right = val;
            }
            else if(val == right+1)
            {
                //if the current value and the right most value have one difference
                right = val;
            }
            else{
                intervals.add(new int[] {left, right});
                left = right = val;
            }
        }
        intervals.add(new int[] {left, right});
        return intervals.toArray(new int[0][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */