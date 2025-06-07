class Solution 
{
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        int prevC = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        int dr[] = new int[]{-1,0,1,0};
        int dc[] = new int[]{0,-1,0,1};
        int m=image.length,n=image[0].length;
        int visited[][] = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                visited[i][j]=-1;
        visited[sr][sc]=1;
        q.add(new int[]{sr,sc});
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int x=pop[0],y=pop[1];

            for(int k=0;k<4;k++)
            {
                int nr=x+dr[k],nc=y+dc[k];
                if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==prevC && visited[nr][nc]==-1)
                {
                    q.add(new int[]{nr,nc});
                    visited[nr][nc]=1;
                }
            }
        }


        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited[i][j]==1)
                {
                    image[i][j]=color;
                }
            }
        }
        return image;
    }
    
}