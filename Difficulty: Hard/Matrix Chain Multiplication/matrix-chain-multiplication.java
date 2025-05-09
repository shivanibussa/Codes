//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().matrixMultiplication(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution 
{
    static int matrixMultiplication(int arr[]) 
    {
        int n = arr.length;
        if (n <= 2) return 0; 
        int dp[][] = new int[n][n];
        for(int i=1;i<n;i++)
            dp[i][i] = 0;
            
        for(int i=n-1;i>=1;i--)
        {
            
            for(int j=i+1;j<n;j++)
            {
                int mini = Integer.MAX_VALUE;
                for(int k=i;k<j;k++)
                {
                    int steps = arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
                    mini = Math.min(mini,steps);
                }
                dp[i][j] = mini;
            }
            
        }
        return dp[1][n-1];   
    }
    static int f(int arr[],int i,int j)
    {
        if(i==j)
            return 0;
            
        int mini = Integer.MAX_VALUE;
        for(int k=i;k<j-1;k++)
        {
            int steps = arr[i-1]*arr[k]*arr[j]+f(arr,i,k)+f(arr,k,j);
            mini = Math.min(mini,steps);
        }
        return mini;
    }
}