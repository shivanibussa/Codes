class Solution 
{
    public void solve(char[][] board) 
    {
        Queue<int[]> q= new LinkedList<>();
        int m = board.length, n=board[0].length;
        int visited[][] = new int[m][n];
        int dr[] = new int[]{-1,0,1,0};
        int dc[] = new int[]{0,-1,0,1};
        for(int i=0;i<m;i++)
        {
            if(board[i][0]=='O')
            {
                q.add(new int[]{i,0});
                visited[i][0] = 1;
            }

            if(board[i][n-1]=='O')
            {
                q.add(new int[]{i,n-1});
                visited[i][n-1]=1;
            }
        }

        for(int j=0;j<n;j++)
        {
            if(board[0][j]=='O')
            {
                q.add(new int[]{0,j});
                visited[0][j]=1;
            }

            if(board[m-1][j]=='O')
            {
                q.add(new int[]{m-1,j});
                visited[m-1][j]=1;
            }
        }

        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int x = pop[0],y=pop[1];

            for(int k=0;k<4;k++)
            {
                int nr = x+dr[k];
                int nc = y+dc[k];

                if(nr>=0 && nc>=0 && nr<m && nc<n && visited[nr][nc]==0 && board[nr][nc]=='O')
                {
                    visited[nr][nc]=1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited[i][j]==0)
                    board[i][j] = 'X';
                else
                    board[i][j] ='O';
            }
        }

    }
}