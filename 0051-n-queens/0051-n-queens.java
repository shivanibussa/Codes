class Solution 
{
    public List<List<String>> solveNQueens(int n) 
    {
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        int lr[] = new int[n];
        int bd[] = new int[2*n-1];
        int ud[] = new int[2*n-1];
        f(ans,lr,bd,ud,board,0);
        return ans;
    }
    public static void f(List<List<String>> ans,int lr[],int bd[],int ud[],char board[][],int col)
    {
        if(col==board.length)
            ans.add(construct(board));
        for(int row=0;row<board.length;row++)
        {
            if(lr[row]==0 && bd[row+col]==0 && ud[board.length-1+col-row]==0)
            {
                board[row][col] = 'Q';
                lr[row]=1;
                ud[board.length-1+col-row]=1;
                bd[row+col]=1;
                f(ans,lr,bd,ud,board,col+1);
                board[row][col] = '.';
                lr[row]=0;
                ud[board.length-1+col-row]=0;
                bd[row+col]=0;
            }
        }
    }

    public static List<String> construct(char[][] board)
    {
        List<String> res = new LinkedList<>();
        for(int i=0;i<board.length;i++)
        {
            String s= new String(board[i]);
            res.add(s);
        }
        return res;
    }
}