class Solution 
{
    public int orangesRotting(int[][] grid) 
    {
        int m=grid.length,n=grid[0].length,maxT=0,fresh=0,rot=0;
        int visited[][] = new int[m][n];
         Queue<int[]> q = new LinkedList<>();
        int dr[] = new int[]{-1,0,1,0};
        int dc[] = new int[]{0,-1,0,1};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i,j,0});
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int x = pop[0], y = pop[1], t = pop[2];
            maxT = Math.max(maxT,t);
            for(int k=0;k<4;k++)
            {
                int nr=x+dr[k],nc=y+dc[k];
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1 && visited[nr][nc]==0)
                {
                    q.add(new int[]{nr,nc,t+1});
                    visited[nr][nc]=1;
                    rot++;
                }
            }
        }
        return fresh==rot ? maxT : -1;
    }
}