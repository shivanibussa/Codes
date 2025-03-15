//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int W = Integer.parseInt(in.readLine().trim());
            String line2[] = in.readLine().trim().split(" ");
            int N = line2.length;
            int val[] = new int[N];
            for (int i = 0; i < N; i++) val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split(" ");
            int wt[] = new int[N];
            for (int i = 0; i < N; i++) wt[i] = Integer.parseInt(line3[i]);

            Solution ob = new Solution();
            System.out.println(ob.knapSack(val, wt, W));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    static int knapSack(int val[], int wt[], int capacity) 
    {
        int n = val.length;
        int dp[][] = new int[n][capacity+1];
        for(int i=0;i<=capacity;i++)
        {
                dp[0][i] = (i/wt[0])*val[0];
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=capacity;j++)
            {
                int not_take = dp[i-1][j];
                int take = Integer.MIN_VALUE;
                if(j>=wt[i])
                    take = val[i]+dp[i][j-wt[i]];
                    
                dp[i][j] = Math.max(take,not_take);
            }
        }
        return dp[n-1][capacity];
    }
}