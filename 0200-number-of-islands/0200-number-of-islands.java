class Solution 
{
    private int gridvis[][];
    public int numIslands(char[][] grid) 
    {
        int n = grid[0].length,islands=0,m=grid.length;
        gridvis = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1' && gridvis[i][j]==0)
                {
                    bfs(i,j,m,n,grid);
                    System.out.println(i+" fdhdfgh "+j);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void bfs(int i, int j,int m,int n,char[][] grid)
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        while(!q.isEmpty())
        {
            int pops[] = q.poll();
            int r = pops[0];
            int c = pops[1];
            gridvis[r][c] = 1;
            if(r>=0 && c>=0 && r<m && c<n)
            {
                if(r+1<m &&grid[r+1][c]=='1' && gridvis[r+1][c]==0)
                {
                    q.add(new int[]{r+1,c});
                    gridvis[r+1][c]=1;
                }
                if(r-1>=0 && grid[r-1][c]=='1' && gridvis[r-1][c]==0)
                {
                    q.add(new int[]{r-1,c});
                    gridvis[r-1][c]=1;
                }
                if(c-1>=0 && grid[r][c-1]=='1' && gridvis[r][c-1]==0)
                {
                    q.add(new int[]{r,c-1});
                    gridvis[r][c-1]=1;
                }
                if(c+1<n && grid[r][c+1]=='1' && gridvis[r][c+1]==0)
                {
                    q.add(new int[]{r,c+1});
                    gridvis[r][c+1]=1;
                }
            }

        }

    }
}