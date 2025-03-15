//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    public int longestCommonSubstr(String t1, String t2) 
    {
        int m = t1.length(),n=t2.length();
        int dp[][] = new int[t1.length()+1][t2.length()+1];
        int maxi=0;
        for(int i=1;i<=t1.length();i++)
        {
            for(int j=1;j<=t2.length();j++)
            {
                if(t1.charAt(i-1)==t2.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                    maxi = Math.max(maxi,dp[i][j]);
                }
            }
        }
        return maxi;
    }
}