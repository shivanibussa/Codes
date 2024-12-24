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
        int leftrow[] = new int[n];
        int belowdiagonal[] = new int[2*n-1];
        int upperdiagonal[] = new int[2*n-1];
        helper(ans,leftrow,belowdiagonal,upperdiagonal,board,0);
        return ans;
    }
    public static void helper(List<List<String>> ans, int[] leftrow,int lowd[], int upd[],char board[][], int col)
    {
        if(col==board.length)
        {
            ans.add(construct(board));
        }
        for(int row=0;row<board.length;row++)
        {
            if(leftrow[row]==0 && lowd[row+col]==0 && upd[board.length-1+col-row]==0)
            {
                board[row][col] = 'Q';
                leftrow[row]=1;
                lowd[row+col]=1;
                upd[board.length-1+col-row]=1;
                helper(ans,leftrow,lowd,upd,board,col+1);
                board[row][col] = '.';
                leftrow[row]=0;
                lowd[row+col]=0;
                upd[board.length-1+col-row]=0;
            }
        }
    }
    static List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}