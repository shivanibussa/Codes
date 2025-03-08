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


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] target) {

        int m = grid.length;
        int n = grid[0].length;
       int dist[][] = new int[m][n];
       for(int i=0;i<m;i++)
       {
           for(int j=0;j<n;j++)
           {
               dist[i][j] = Integer.MAX_VALUE;
           }
       }
       int sx=source[0],sy=source[1];
       dist[sx][sy]=0;
       int tx = target[0], ty = target[1];
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
       pq.offer(new int[]{0,sx,sy});
       while(!pq.isEmpty())
       {
           int pop[] = pq.poll();
           int w = pop[0];
           int x = pop[1];
           int y = pop[2];
           int dr[] = {-1,0,1,0};
           int dc[] = {0,-1,0,1};
           for(int i=0;i<4;i++)
           {
               int nr = x+dr[i];
               int nc = y+dc[i];
               if(nr>=0 &&nr<m && nc>=0 && nc<n && grid[nr][nc]==1 && 1+dist[x][y]<dist[nr][nc])
               {
                   dist[nr][nc] = 1+dist[x][y];
                   pq.add(new int[]{dist[nr][nc],nr,nc});
               }
           }
       }
       return dist[tx][ty] != Integer.MAX_VALUE ? dist[tx][ty]:-1;
    }
}
