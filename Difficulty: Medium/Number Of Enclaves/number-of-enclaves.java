//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        
out.println("~");
}
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{

    int numberOfEnclaves(int[][] grid) 
    {
        int m = grid.length, n = grid[0].length;
        int visited[][] = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 || i==m-1 || j==0 || j==n-1)
                {
                    if(grid[i][j]==1)
                    {
                        q.add(new int[]{i,j});
                        visited[i][j]=1;
                    }
                }
            }
        }
        
        while(!q.isEmpty())
        {
            int[] pops = q.poll();
            int r= pops[0];
            int c = pops[1];
            
            int dr[] = {-1,0,1,0};
            int dc[] = {0,-1,0,1};
            for(int i=0;i<4;i++)
            {
                int nr = r+dr[i];
                int nc = c+dc[i];
                
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1 && visited[nr][nc]==0)
                {
                    q.add(new int[]{nr,nc});
                    visited[nr][nc]=1;
                }
            }
            
        }
        int cnt=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1 && visited[i][j]==0)
                {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}