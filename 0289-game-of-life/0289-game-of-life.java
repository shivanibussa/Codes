
/*
    Original New Res
        0     0   0
        1     0   1
        0     1   2
        1     1   3
*/
class Solution 
{
    public void gameOfLife(int[][] board) 
    {
        int rows = board.length, cols = board[0].length;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                int n = countNeighbors(board,i,j);
                if(board[i][j]==1)
                {
                    if(n==2 || n==3)
                        board[i][j] = 3;
                }
                else if(n==3)
                {
                    board[i][j] = 2;
                }
            }
        }

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(board[i][j]==1)
                    board[i][j] = 0;
                else if(board[i][j]==2 || board[i][j]==3)
                    board[i][j] = 1;
            }
        }

    }
    public int countNeighbors(int board[][],int i,int j)
    {
        int cnt=0;
        for(int r=-1;r<=1;r++)
        {
            for(int c=-1;c<=1;c++)
            {
                int nr = i+r, nc =j+c;
                if(nr<0 || nr>=board.length || nc<0 || nc>=board[0].length || (nr==i && nc==j))
                    continue;
                if(board[nr][nc]==1 || board[nr][nc]==3)
                    cnt++; 

            }
        }
        return cnt;
    }
}