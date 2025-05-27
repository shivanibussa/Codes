class Solution 
{
    public void solveSudoku(char[][] board) 
    {
        f(board);
    }
    public boolean f(char board[][])
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                {
                    for(char c='1';c<='9';c++)
                    {
                        if(isValid(board,i,j,c)==true)
                        {
                            board[i][j]=c;
                            if(f(board)==true)
                                return true;
                            else
                                board[i][j]='.';
                        }
                    }
                    return false;
                    
                }
                
            }
        }
        return true;
    }
    public boolean isValid(char board[][],int r,int c,char ch)
    {
        for(int i=0;i<9;i++)
        {
            if(board[i][c]==ch)
                return false;
            if(board[r][i]==ch)
                return false;
            if(board[3*(r/3)+i/3][3*(c/3)+i%3]==ch)
                return false;
        }
        return true;
    }
}