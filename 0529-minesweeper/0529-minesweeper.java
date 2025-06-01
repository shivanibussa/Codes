class Solution 
{
    public int cntAdjacentMines(int r,int c,char board[][])
    {
        int rows = board.length,cols=board[0].length,cnt=0;
        for(int i=-1;i<2;i++)
        {
            for(int j=-1;j<2;j++)
            {
                int nr=i+r;
                int nc=c+j;
                if(nr>=0 && nr<rows && nc>=0 && nc<cols && board[nr][nc]=='M')
                    cnt+=1;
            }
        }
        return cnt;
    }
    public char[][] updateBoard(char[][] board, int[] click) 
    {

        int x= click[0], y=click[1],rows=board.length,cols=board[0].length;
        if(board[x][y]=='M')
            board[x][y]='X';
        else
        {
            int n = cntAdjacentMines(x,y,board);
            if(n!=0)
            {
                board[x][y] = (char)(n+'0');
            }
            else
            {
                board[x][y]='B';
                for(int i=-1;i<2;i++)
                {
                    for(int j=-1;j<2;j++)
                    {
                        int nr = x+i,nc=j+y;
                        if(nr>=0 && nr<rows && nc>=0 && nc<cols && board[nr][nc]!='B')
                        {
                            updateBoard(board,new int[]{nr,nc});
                        }
                    }
                }
            }
        }
        return board;
    }
}