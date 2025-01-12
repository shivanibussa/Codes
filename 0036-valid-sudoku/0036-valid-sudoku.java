class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        HashMap<Integer,HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer,HashSet<Character>> cols = new HashMap<>();
        HashMap<Integer,HashSet<Character>> squares = new HashMap<>();

        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                    continue;
                if(rows.getOrDefault(i,new HashSet<>()).contains(board[i][j]) || cols.getOrDefault(j,new HashSet<>()).contains(board[i][j]) ||
                squares.getOrDefault((i/3)*3+(j/3),new HashSet<>()).contains(board[i][j]))
                {
                    return false;
                }
                rows.computeIfAbsent(i,k -> new HashSet<>()).add(board[i][j]);
                cols.computeIfAbsent(j,k -> new HashSet<>()).add(board[i][j]);
                squares.computeIfAbsent((i/3)*3+(j/3), k -> new HashSet<>()).add(board[i][j]);
            }
        }
        return true;
    }
}