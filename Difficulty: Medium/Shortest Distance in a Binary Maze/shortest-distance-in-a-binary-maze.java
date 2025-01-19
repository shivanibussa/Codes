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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

class Solution 
{

    int shortestPath(int[][] grid, int[] source, int[] destination) 
    {
        int m = grid.length;
        int n = grid[0].length;
        int dist[][] = new int[m][n];
        Queue<int[]>q = new LinkedList<>();
        int sx = source[0], sy = source[1];
        int ex = destination[0], ey = destination[1];
        int dr[] = {-1,0,1,0};
        int dc[] = {0,-1,0,1};
            
        q.add(new int[]{0,sx,sy});
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[sx][sy]=0;
        
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int wt = pop[0], x = pop[1], y = pop[2];
            
            if(x==ex && y==ey)
            {
                return wt;
            }
            for(int i=0;i<4;i++)
            {
                int nx=x+dr[i], ny = y+dc[i];
                if(nx>=0 && ny>=0 && nx<m && ny<n && grid[nx][ny]==1 && dist[nx][ny]>wt+1)
                {
                    dist[nx][ny] = wt+1;
                    if(nx==ex && ny==ey)
                    {
                        return wt+1;
                    }
                    q.offer(new int[]{wt+1,nx,ny});
                }
            }
            
        }
        return -1;
    }
}
