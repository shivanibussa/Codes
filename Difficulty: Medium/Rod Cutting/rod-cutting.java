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
        for(int i=0;i<n+1;i++)
        {
            dp[0][i] = i*price[0];
        }
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<n+1;j++)
            {
                int not_take = dp[i-1][j];
                int take = Integer.MIN_VALUE;
                int rl = i+1;
                if(j>=rl)
                    take = price[i]+dp[i][j-rl];
                    
                dp[i][j] = Math.max(not_take,take);
            }
        }
        return dp[n-1][n];
    }
    public int f(int price[],int n,int ind)
    {
        if(ind==0)
        {
            return n*price[0]; 
        }
        int not_take = 0+f(price,n,ind-1);
        int take = Integer.MIN_VALUE;
        if(n>=ind+1)
            take = price[ind]+f(price,n-ind+1,ind);
            
        return Math.max(take,not_take);
    }
}