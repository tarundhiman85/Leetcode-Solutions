// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> it;
    private int num = 0;        //keep the last peek int
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.it = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(num == 0)
            num = it.next();
        
        return num;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(num != 0) {
            int out = num;
            num = 0;
            return out;
        }
        
	    return it.next();
	}
	
	@Override
	public boolean hasNext() {
	    return num != 0 ? true : it.hasNext();
	}
}