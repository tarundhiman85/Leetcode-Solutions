//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
  public int minSum(int nums[], int sum, boolean dp[][])
  { 
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(j == 0) dp[i][j] = true;
            }
        }
           
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                
                if(nums[i-1] <= j){
                    //take or not take
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                } else{
                    //take only
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int n = nums.length;
        int minS = Integer.MAX_VALUE;
        for(int i=0; i<=sum; i++)
        {
            if(dp[n-1][i])
            {
                minS = Math.min(minS,Math.abs((sum-i)-i));
            }
        }
        return minS;
    }
	public int minDifference(int nums[], int n) 
	{ 
	    int sum = 0;

        for(int i : nums) sum+=i;
        
        
        boolean dp[][] = new boolean[n+1][sum+1];
        
        return minSum(nums, sum, dp);
	} 
}
