class Solution 
{
    public int numEnclaves(int[][] board) 
    {
        int m = board.length, n=board[0].length;
        int visited[][] = new int[m][n];
        int cnt=0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            if(board[i][0]==1)
                q.add(new int[]{i,0});
            if(board[i][n-1]==1)
                q.add(new int[]{i,n-1});
        }
        for(int j=0;j<n;j++)
        {
            if(board[0][j]==1)
                q.add(new int[]{0,j});
            
            if(board[m-1][j]==1)
                q.add(new int[]{m-1,j});
        }
        int dr[] = new int[]{-1,0,1,0};
        int dc[] = new int[]{0,-1,0,1};
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int r = pop[0], c = pop[1];
            visited[r][c] = 1;
            for(int k=0;k<4;k++)
            {
                int nr = r+dr[k];
                int nc = c+dc[k];
                if(nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc]==1 && visited[nr][nc]==0)
                {
                    visited[nr][nc] = 1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==1 && visited[i][j]==0)
                    cnt++;
            }
        }
        return cnt;
    }
}