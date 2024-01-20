// MAIN LOGIC : find the next samllest and previous samllest of each element in the given array and then just ue those two arrays to calculate number of subarrays a number would appear in and will be the minimum in them.
// so take left range till we find smaller in the left and right range till we find a samller element in the right .

// now we will have lest boundary and right boundary of elements in which our current element would be the minimum now just calculate such number of subarrays and the formula for this will be -->
// range till left +1 * range till right +1 * arr[i]

// example--> arr = [1,6,2,4,5,1] for 2 we have 6,[2],4,5 -->
// left range = 1
// right range = 2
// include the elmnt itself too then becomes 1+1(left) =2 and 2+1(right) =3

// 2*3 = 6 gives the numbers of subarrays in which 2 will be min so we add 2 six times and repeat the processs for every other element

// BASE CASE : when is there is no samller element in right that means we have to include all the elements till end of array so it is given by --> length - i -1
// Similarly when there is no smaller element in the left then we have to include all the elements in the left till start of array that is given by --> index of its own = i

 class Solution {

public int sumSubarrayMins(int[] arr) {
    
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    int n = arr.length;
    
    int NS[] = new int [n];
    int PS[] = new int [n];
    
	//for base case: when is there is no smallest element in the left or right
    for(int i =0; i<n; i++){
        NS[i] = n-i-1;
        PS[i] = i;
    }
    //find next smallest
    for(int i=0; i<n; i++){
        while(!stack1.empty() && arr[stack1.peek()] > arr[i]){
            NS[stack1.peek()] = i-stack1.peek() -1;
            stack1.pop();
        }
        stack1.push(i);
    }
    //find prev amallest
    for(int i=n-1; i>=0; i--){
        while(!stack2.empty() && arr[stack2.peek()] >= arr[i]){
            PS[stack2.peek()] = stack2.peek() -i-1;
            stack2.pop();
        }
        stack2.push(i);
    }
  
    long ans =Long.valueOf(0);
    for(int i =0; i<n; i++){
        long left = PS[i] +1;
        long right = NS[i] +1;
        ans += (arr[i]*left*right);
    }
    return (int)(ans %(Math.pow(10,9) +7));
}
 }