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
    public int longestCommonSubstr(String s1, String s2) 
    {
        int m = s1.length(), n= s2.length(),maxi=0;
        int dp[][] = new int[m+1][n+1];
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=0;i<m+1;i++)
        {
            for(int j=0;j<n+1;j++)
            {
                maxi = Math.max(maxi,dp[i][j]);
            }
        }
        return maxi;
    }
}