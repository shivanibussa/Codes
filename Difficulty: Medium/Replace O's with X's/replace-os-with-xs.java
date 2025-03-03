//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int m = Integer.parseInt(in.readLine());
            char mat[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                String S[] = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = S[j].charAt(0);
                }
            }

            Solution ob = new Solution();
            char[][] ans = ob.fill(mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(ans[i][j] + " ");
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
    static char[][] fill(char mat[][]) 
    {
        int m = mat.length,n = mat[0].length;
        char res[][] = new char[m][n];
        boolean visited[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((i==0 || i==m-1 || j==0 || j==n-1) && mat[i][j]=='O')
                {
                    res[i][j] = 'O';
                    visited[i][j] = true;
                    q.add(new int[]{i,j});
                }
                else
                    res[i][j] = 'X';
            }
        }
        
        while(!q.isEmpty())
        {
            int pops[] = q.poll();
            int u = pops[0];
            int v = pops[1];
            
            int dr[] = {-1,0,1,0};
            int dc[] = {0,-1,0,1};
            
            for(int i=0;i<4;i++)
            {
                int nr = u+dr[i];
                int nc = v+dc[i];
                
                if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc]=='O' && !visited[nr][nc])
                {
                    res[nr][nc] = 'O';
                    visited[nr][nc] = true;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return res;
    }
}