//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < s.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr));

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution 
{
    public int cutRod(int[] price) 
    {
        int n = price.length;
        int dp[][] = new int[n][n+1];
        for(int i=0;i<=n;i++)
        {
            dp[0][i] = i*price[0];
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                int not_take = dp[i-1][j];
                int take = Integer.MIN_VALUE;
                if(j>=i+1)
                    take = dp[i][j-(i+1)]+price[i];
                    
                dp[i][j] = Math.max(take,not_take);
            }
        }
        return dp[n-1][n];
    }
}