class Solution 
{
    public int[][] updateMatrix(int[][] mat) 
    {
        int m = mat.length, n= mat[0].length;
        Queue<int[]> q= new LinkedList<>();
        int visited[][] = new int[m][n];
        int dist[][] = new int[m][n];
        int dr[] = new int[]{-1,0,1,0};
        int dc[] = new int[]{0,-1,0,1};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new int[]{i,j,0});
                }
            }
        }

        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int x = pop[0],y=pop[1],d=pop[2];
            
            for(int k=0;k<4;k++)
            {
                int nr = x+dr[k];
                int nc = y+dc[k];

                if(nr>=0 && nr<m && nc>=0 && nc<n && visited[nr][nc]==0 && mat[nr][nc]==1)
                {
                    visited[nr][nc]=1;
                    dist[nr][nc]=d+1;
                    q.add(new int[]{nr,nc,dist[nr][nc]});
                }
            }

        }
        return dist;
    }
}