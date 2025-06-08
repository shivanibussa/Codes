// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]>q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int dist[][] = new int[m][n];
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dist[i][j] = (int)1e9;
            }
        }
        int sx = source[0],sy=source[1],tx=destination[0],ty=destination[1];
        dist[sx][sy]=0;
        q.offer(new int[]{0,sx,sy});
        int dr[] = new int[]{-1,0,1,0};
        int dc[] = new int[]{0,-1,0,1};
        while(!q.isEmpty())
        {
            int poll[] = q.poll();
            int wt = poll[0];
            int x = poll[1];
            int y = poll[2];
            for(int k=0;k<4;k++)
            {
                int nr = dr[k]+x;
                int nc = dc[k]+y;
                
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1 && dist[nr][nc]>wt+1)
                {
                    dist[nr][nc] = 1+wt;
                    q.offer(new int[]{1+wt,nr,nc});
                }
                
            }
            
        }
        return dist[tx][ty]==(int)1e9?-1:dist[tx][ty];
    }
}
