//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    public void bfs(int r,int c,int grid[][],int visited[][],ArrayList<String>al,int r0,int c0)
    {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = 1;
        q.offer(new int[]{r,c});
        int dr[] = {-1,0,1,0};
        int dc[] = {0,-1,0,1};
        
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int x=pop[0],y=pop[1];
            al.add(toString(x-r0,y-c0));
            for(int k=0;k<4;k++)
            {
                int nr = x+dr[k];
                int nc = y+dc[k];
                
                if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc]==1 && visited[nr][nc]==0)
                {
                    q.offer(new int[]{nr,nc});
                    visited[nr][nc]=1;
                }
            }
        }
    }
    
    public String toString(int x,int y)
    {
        return Integer.toString(x)+" "+Integer.toString(y);
    }

    int countDistinctIslands(int[][] grid) 
    {
        int m = grid.length, n = grid[0].length;
        int visited[][] = new int[m][n];
        HashSet<ArrayList<String>> hs = new HashSet<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1 && visited[i][j] ==0)
                {
                    ArrayList<String> temp = new ArrayList<>();
                    bfs(i,j,grid,visited,temp,i,j);
                    hs.add(temp);
                }
            }
        }
        return hs.size();
        
    }
}
