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
        boolean visited[][] = new boolean [rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]=='1' && !visited[i][j])
                {
                    bfs(i,j,grid,visited);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    public void bfs(int r, int c,char grid[][], boolean visited[][])
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;
        while(!q.isEmpty())
        {
            int pops[] = q.poll();
            int a = pops[0];
            int b = pops[1];
            int dr[] = {-1,-1,-1,0,1,1,1,0};
            int dc[] = {-1,0,1,1,1,0,-1,-1};
            for(int i=0;i<8;i++)
            {
                int nr = a+dr[i];
                int nc = b+dc[i];
                
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='1'
                && !visited[nr][nc])
                {
                    q.add(new int[]{nr,nc});
                    visited[nr][nc]=true;
                }
            }
        }
    }
}