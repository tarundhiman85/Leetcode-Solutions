//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        int i, j;
        
        // Sorting the jobs in descending order of their profits.
        Arrays.sort(arr, new sort());
        
        // Creating an array to store the result.
        int[] res = new int[2];
        
        // Creating a temporary array to track the availability of time slots.
        int[] tem = new int[101];
        
        // Iterating over the jobs in reverse order.
        // This ensures we prioritize jobs with higher profits first.
        for (i = n - 1; i >= 0; i--) {
            // Checking for available time slots starting from the job's deadline.
            for (j = arr[i].deadline; j > 0; j--) {
                // If the time slot is available, we can schedule the job.
                if (tem[j] == 0) {
                    // Incrementing the count of jobs scheduled.
                    res[0]++;
                    // Adding the job's profit to the total profit.
                    res[1] += arr[i].profit;
                    // Storing the job's ID in the time slot.
                    tem[j] = arr[i].id;
                    // Exiting the inner loop since the job is scheduled.
                    break;
                }
            }
        }
        
        // Returning the result array containing the count and total profit.
        return res;
    }
}

// Custom comparator class to sort jobs based on their profits.
class sort implements Comparator<Job> {
    // Method to compare two jobs based on their profits.
    public int compare(Job a, Job b) {
        // Sorting in ascending order of profit.
        return a.profit - b.profit;
    }
}