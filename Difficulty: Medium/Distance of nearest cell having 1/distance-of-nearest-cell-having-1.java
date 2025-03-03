//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
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
    
    public int[][] nearest(int[][] grid)
    {
        int m = grid.length,n=grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int dist[][] = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    q.add(new int[]{i,j,0});
                }
            }
        }
        while(!q.isEmpty())
        {
            int pops[] = q.poll();
            int u = pops[0];
            int v = pops[1];
            int d = pops[2];
            
            int dr[] = {-1,0,1,0};
            int dc[] = {0,-1,0,1};
            
            for(int i=0;i<4;i++)
            {
                int nr = u+dr[i];
                int nc = v+dc[i];
                
                if(nr>=0 && nr<m && nc>=0 && nc<n && dist[nr][nc]==0
                && grid[nr][nc]==0 && !visited[nr][nc])
                {
                    visited[nr][nc] = true;
                    dist[nr][nc] = d+1;
                    q.add(new int[]{nr,nc,d+1});
                }
            }
        }
        return dist;
    }
}