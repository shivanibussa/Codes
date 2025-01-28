//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution 
{
    public int numIslands(char[][] grid) 
    {
        int rows = grid.length,cols = grid[0].length, islands=0;
        int visited[][] = new int [rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]=='1' && visited[i][j]==0)
                {
                    dfs(grid,visited,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(char grid[][], int visited[][],int r, int c)
    {
        visited[r][c]=1;
        int dr[] = {-1,-1,0,1,1,1,0,-1};
        int dc[] = {0,-1,-1,-1,0,1,1,1};
        int rows = grid.length,cols=grid[0].length;
        for(int k=0;k<8;k++)
        {
            int nr = r+dr[k];
            int nc = c+dc[k];
            
            if(nr>=0 && nc>=0 && nr<rows && nc<cols)
            {
                if(grid[nr][nc]=='1' && visited[nr][nc]==0)
                {
                    dfs(grid,visited,nr,nc);
                }
            }
        }
    }
}