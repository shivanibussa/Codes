class Solution 
{
    public int orangesRotting(int[][] grid) 
    {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int visited[][] = new int[m][n];
        int totT=0, fresh = 0, rot = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new int[]{i,j,0});
                    visited[i][j] = 2;
                }
                if(grid[i][j]==1)
                {
                    fresh++;
                }

            }
        }
        int dr[] = {-1,0,1,0};
        int dc[] = {0,-1,0,1};

        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int x = pop[0],y=pop[1],t=pop[2];
            totT = totT<t ? t :totT;
            for(int k=0;k<4;k++)
            {
                int nr = x+dr[k], nc = y+dc[k];
                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1 && visited[nr][nc]!=2)
                {
                    visited[nr][nc] = 2;
                    q.offer(new int[]{nr,nc,t+1});
                    rot++;
                }
            }
        }
        return fresh==rot ? totT : -1;
    }
}