//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.minOperations(s1, s2));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    public int minOperations(String s1, String s2) 
    {
        int m = s1.length(),n=s2.length();
        int total = m+n;
        int dp[][] = new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return total-(2*dp[m][n]);
    }
}