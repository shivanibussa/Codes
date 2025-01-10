class Solution 
{
    public void solve(char[][] board) 
    {
        int m = board.length;
        int n = board[0].length;
        int visited[][] = new int[m][n];

        for(int i=0;i<n;i++)
        {
            if(board[0][i]=='O' && visited[0][i]==0)
                bfs(0,i,board,visited);
            if(board[m-1][i]=='O' && visited[m-1][i]==0)
                bfs(m-1,i,board,visited);
            
        }
        for(int i=0;i<m;i++)
        {
            if(board[i][0]=='O' && visited[i][0]==0)
                bfs(i,0,board,visited);
            if(board[i][n-1]=='O' && visited[i][n-1]==0)
                bfs(i,n-1,board,visited);
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited[i][j]==0)
                {
                    board[i][j]='X';
                }
            }
        }
    }

    public void bfs(int i,int j,char board[][],int visited[][])
    {
        Queue<int[]> q = new LinkedList<>();
        int rows = board.length;
        int n = board[0].length;
        q.add(new int[]{i,j});
        visited[i][j]=1;

        while(!q.isEmpty())
        {
            int pops[] = q.poll();
            int r=pops[0];
            int c=pops[1];
            int dr[]={-1,0,1,0};
            int dc[]={0,-1,0,1};
            for(int m=0;m<4;m++)
            {
                int nr = r+dr[m];
                int nc = c+dc[m];

                if(nr>=0 && nc>=0 && nr<rows && nc<n && board[nr][nc]=='O' && visited[nr][nc]==0)
                {
                    q.add(new int[]{nr,nc});
                    visited[nr][nc]=1;
                }
            }
        }
    }
}