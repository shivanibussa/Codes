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
    static int knapSack(int val[], int wt[], int W) 
    {
        int n = val.length;
        int dp[][] = new int[n][W+1];
        for(int j=0;j<=W;j++)
        {
            if(j>=wt[0])
                dp[0][j] = val[0]*(j/wt[0]);
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=W;j++)
            {
                int not_take = dp[i-1][j];
                int take = Integer.MIN_VALUE;
                if(j>=wt[i])
                    take = val[i]+dp[i][j-wt[i]];
                    
                dp[i][j] = Math.max(take,not_take);
            }
        }
       return dp[n-1][W];
    }
    static int f(int val[],int wt[],int W,int ind)
    {
        if(ind==0)
        {
            if(W>=wt[0])
                return val[0]*(W/wt[0]);
            else
                return 0;
        }
        int not_take = 0+f(val,wt,W,ind-1);
        int take = Integer.MIN_VALUE;
        if(W>=wt[ind])
            take = val[ind]+f(val,wt,W-wt[ind],ind);
            
        return Math.max(take,not_take);
    }
}