class Solution 
{
    public int numIslands(char[][] grid) 
    {
        int m = grid.length, n = grid[0].length;
        int visited[][] = new int[m][n];
        int cnt=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1' && visited[i][j]==0)
                {
                    bfs(i,j,grid,visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void bfs(int i,int j,char grid[][],int visited[][])
    {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length,cols = grid[0].length;
        int dr[] = new int[]{-1,0,1,0};
        int dc[] = new int[]{0,-1,0,1};
        visited[i][j] = 1;
        q.offer(new int[]{i,j});
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int r = pop[0];
            int c = pop[1];

            for(int k=0;k<4;k++)
            {
                int nr = r+dr[k];
                int nc = c+dc[k];

                if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc]=='1' && visited[nr][nc]==0)
                {
                    q.offer(new int[]{nr,nc});
                    visited[nr][nc]=1;
                }
            }
        }
    }
}