class Solution 
{
    public int orangesRotting(int[][] grid) 
    {
        Queue<int[]> q = new LinkedList<>();
        int fresh=0,rot=0;
        int m = grid.length, n = grid[0].length, t =0;
        int visited[][] = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i,j,0});
                    visited[i][j] = 2;
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }

        int dr[] = new int[]{-1,0,1,0};
        int dc[] = new int[]{0,-1,0,1};

        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int r = pop[0], c = pop[1], time = pop[2];

            for(int k=0;k<4;k++)
            {
                int nr = r+dr[k];
                int nc = c+dc[k];

                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1 && visited[nr][nc]!=2)
                {
                    visited[nr][nc] = 2;
                    q.add(new int[]{nr,nc,time+1});
                    t = Math.max(t,time+1);
                    rot++;
                }
            }
        }
        if(fresh!=rot)
            return -1;
        return t;
    }
}