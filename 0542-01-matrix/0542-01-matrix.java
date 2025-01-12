class Solution 
{
    public int[][] updateMatrix(int[][] mat) 
    {
        int m = mat.length,n=mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int visited[][] = new int[m][n];
        int dist[][] = new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    q.offer(new int[]{i,j,0});
                }
            }
        }

        while(!q.isEmpty())
        {
            int pops[] = q.poll();
            int r = pops[0];
            int c = pops[1];
            int d = pops[2];

            int dr[] = {-1,0,1,0};
            int dc[] = {0,-1,0,1};

            for(int i=0;i<4;i++)
            {
                int nr = r+dr[i];
                int nc = c+dc[i];

                if(nr>=0 && nc>=0 && nr<m && nc<n
                && visited[nr][nc]==0 && mat[nr][nc]==1)
                {
                    q.offer(new int[]{nr,nc,d+1});
                    visited[nr][nc]=1;
                    dist[nr][nc] = d+1;
                }
            }
        }
        return dist;
    }
}