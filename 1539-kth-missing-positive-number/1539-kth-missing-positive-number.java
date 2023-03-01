class Solution {
    public int binarySearch(int[] arr, int k, int leftI, int rightI)
{
	int amountOfmissingNums = 0;
	if(leftI >= rightI) //end condition
	{
		amountOfmissingNums = arr[leftI] - leftI - 1;
		if(amountOfmissingNums >= k) //go left
		{
			k = amountOfmissingNums - k + 1;
			return arr[leftI] - k; 
		}
		else //smaller go right
		{
			k = k - amountOfmissingNums;
			return arr[leftI] + k;
		}
	}
	int midI = (leftI + rightI) / 2;
	amountOfmissingNums = arr[midI] - midI - 1;
	if(amountOfmissingNums >= k) // search left
		return binarySearch(arr, k, leftI, midI - 1); 
	else //search right
		return binarySearch(arr, k, midI + 1, rightI);
}
    public int findKthPositive(int[] arr, int k) {
        return binarySearch(arr, k, 0, arr.length-1);
    }
}


/*

[1] 2 3 4 [5,6] 7 [8,9,10] 11 



*/