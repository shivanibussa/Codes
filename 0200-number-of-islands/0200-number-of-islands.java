class Solution 
{
    public int numIslands(char[][] grid) 
    {
        int m=grid.length,n=grid[0].length,islands=0;
        int visited[][] = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1' && visited[i][j]==0)
                {
                    bfs(grid,visited,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void bfs(char grid[][],int visited[][],int r,int c)
    {
        Queue<int[]> q = new LinkedList<>();
        int dr[] = new int[]{-1,0,1,0};
        int dc[] = new int[]{0,-1,0,1};
        int m=grid.length,n=grid[0].length;
        visited[r][c]=1;
        q.add(new int[]{r,c});
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int x=pop[0],y=pop[1];

            for(int k=0;k<4;k++)
            {
                int nr=x+dr[k],nc=y+dc[k];
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1' && visited[nr][nc]==0)
                {
                    q.add(new int[]{nr,nc});
                    visited[nr][nc]=1;
                }
            }

        }
    }
}