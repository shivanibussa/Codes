//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution 
{

    static Boolean isSubsetSum(int arr[], int k) 
    {
        int n = arr.length;
        boolean dp[][] = new boolean[n][k+1];
        
        for(int i=0;i<n;i++)
            dp[i][0] = true;
        
        if(arr[0]<=k)
            dp[0][arr[0]] = true;
            
        for(int i=1;i<n;i++)
        {
            for(int target=1;target<=k;target++)
            {
                boolean not_take = dp[i-1][target];
                boolean take = false;
                if(arr[i]<=target)
                    take = dp[i-1][target-arr[i]];
                    
                dp[i][target] = take || not_take;
            }
        }
        return dp[n-1][k];
    }
}