class Solution 
{
    public int[][] floodFill(int[][] image, int sr, int sc, int color)
    {
        int m = image.length, n=image[0].length;
        boolean visited[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int col = image[sr][sc];
        q.add(new int[]{sr,sc});
        visited[sr][sc]=true;
        image[sr][sc] = color;
        int dr[] =new int[]{-1,0,1,0};
        int dc[] = new int[]{0,-1,0,1};
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int r = pop[0], c = pop[1];

            for(int k=0;k<4;k++)
            {
                int nr = dr[k]+r;
                int nc = c+dc[k];

                if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc]!=color && image [nr][nc]==col && visited[nr][nc]==false)
                {
                    visited[nr][nc] = true;
                    image[nr][nc] = color;
                    q.add(new int[]{nr,nc});
                }
            }

        }
        return image;
    }
}