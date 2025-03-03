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

    int countDistinctIslands(int[][] grid) 
    {
        int m = grid.length, n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        HashSet<ArrayList<String>> hs = new HashSet<>();
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1 && !visited[i][j])
                {
                    ArrayList<String> arr = new ArrayList<>();
                    dfs(i,j,grid,visited,arr,i,j);
                    hs.add(arr);
                }
            }
        }
        
        return hs.size();
    }
    public void dfs(int row,int col, int[][] grid, boolean[][] visited,ArrayList<String> arr,
    int row0, int col0)
    {
        visited[row][col] = true;
        arr.add(toString(row-row0,col-col0));
        int dr[] = {-1,0,1,0};
        int dc[] = {0,-1,0,1};
        
        for(int i=0;i<4;i++)
        {
            int nr = row+dr[i];
            int nc = col+dc[i];
            
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && 
            grid[nr][nc]==1 && !visited[nr][nc])
            {
                dfs(nr,nc,grid,visited,arr,row0,col0);
            }
        }
        
    }
    public String toString(int r,int c)
    {
        return Integer.toString(r)+" "+Integer.toString(c);
    }
}
