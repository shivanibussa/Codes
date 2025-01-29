class Solution 
{
    public int orangesRotting(int[][] grid) 
    {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length, cols = grid[0].length, fresh=0,cnt=0,res=0;
        int visited[][] = new int[rows][cols];

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i,j,0});
                    visited[i][j]=2;
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
                int pops[] = q.poll();
                int r = pops[0];
                int c = pops[1];
                int t = pops[2];
                res = Math.max(res,t);
                for(int k=0;k<4;k++)
                {
                    int nr = r+dr[k];
                    int nc = c+dc[k];
                    if(nr>=0 && nc>=0 && nr<rows && nc<cols && grid[nr][nc]==1 && visited[nr][nc]!=2)
                    {
                        visited[nr][nc] = 2;
                        q.offer(new int[]{nr,nc,t+1});
                        cnt++;
                    }
                }

            }
        
        if(cnt!=fresh)
            return -1;
        else 
            return res;

    }
}
