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
class Solution 
{

    int countDistinctIslands(int[][] grid) 
    {
        int m = grid.length,n=grid[0].length;
        HashSet<ArrayList<String>> set = new HashSet<>();
        int vis[][] = new int[m][n];
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                {
                    ArrayList<String> arr = new ArrayList<>();
                    helper(grid,vis,i,j,arr,set,i,j);
                    set.add(arr);
                }
            }
        }
        return set.size();
    }
    public void helper(int[][] grid,int[][] vis,int row,int col,
    ArrayList<String> arr,HashSet<ArrayList<String>> set,int row0,int col0)
    {
        vis[row][col]=1;
        arr.add(toString(row-row0, col-col0));
        int m = grid.length;
        int n = grid[0].length;
        
        int dr[] = {-1,0,1,0};
        int dc[] = {0,-1,0,1};
        
        for(int i=0;i<4;i++)
        {
            int nr=dr[i]+row;
            int nc=dc[i]+col;
            
            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1 && vis[nr][nc]==0)
            {
                helper(grid,vis,nr,nc,arr,set,row0,col0);
            }
        }
    }
    public String toString(int r,int c)
    {
        return Integer.toString(r)+" "+Integer.toString(c);
    }
}
