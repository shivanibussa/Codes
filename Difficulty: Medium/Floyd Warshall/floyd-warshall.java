//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().trim().split(" ");
                for (int j = 0; j < n; j++) matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortestDistance(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution 
{
    public void shortestDistance(int[][] mat) 
    {
        int m = mat.length;
       for(int i=0;i<m;i++)
       {
           for(int j=0;j<m;j++)
           {
               if(mat[i][j]==-1)
                mat[i][j] = (int)1e8;
                if(i==j)
                    mat[i][j] = 0;
           }
       }
       for(int k=0;k<m;k++)
       {
           for(int i=0;i<m;i++)
           {
               for(int j=0;j<m;j++)
               {
                   mat[i][j] = Math.min(mat[i][j],(mat[i][k]+mat[k][j]));
               }
           }
       }
       for(int i=0;i<m;i++)
       {
           for(int j=0;j<m;j++)
           {
               if(mat[i][j]==(int)1e8)
                mat[i][j] = -1;
           }
       }
    }
}