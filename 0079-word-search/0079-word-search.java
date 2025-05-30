class Solution 
{
    public boolean exist(char[][] board, String word) 
    {
        int rows = board.length, cols = board[0].length;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(f(board,i,j,word,0)==true)
                    return true;
            }
        }
        return false;
    }

    public boolean f(char board[][],int r,int c,String word,int ind)
    {
        if(ind==word.length())
            return true;
        
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c]!=word.charAt(ind) || board[r][c]=='#')
            return false;

        board[r][c]='#';
        boolean res = f(board,r+1,c,word,ind+1)||f(board,r,c+1,word,ind+1)||f(board,r-1,c,word,ind+1)||f(board,r,c-1,word,ind+1);
        board[r][c] = word.charAt(ind);
        return res;
    }
}