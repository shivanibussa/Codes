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


class Solution 
{
    static Boolean isSubsetSum(int arr[], int sum) 
    {
        int n = arr.length;
        boolean dp[][] = new boolean[n][sum+1];
        for(int i=0;i<n;i++)
            dp[i][0] = true;
            
        if(arr[0]<=sum)
            dp[0][arr[0]] = true;
            
            
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                boolean not_take = dp[i-1][j];
                boolean take = false;
                if(j>=arr[i])
                    take = dp[i-1][j-arr[i]];
                    
                dp[i][j] = take || not_take;
            }
        }
        return dp[n-1][sum];
    }
    static boolean f(int arr[],int target,int i)
    {
        if(target==0)
            return true;
        
        if(i==0)
            return arr[i]==target?true:false;
            
        
        boolean not_take = f(arr,target,i-1);
        boolean take = false;
        if(arr[i]<=target)
            take = f(arr,target-arr[i],i-1);
            
        return take||not_take;
    }
}