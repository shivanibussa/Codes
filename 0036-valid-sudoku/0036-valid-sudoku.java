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
                char ch = board[i][j];
                if(ch!='.')
                {
                    if(rows.getOrDefault(i,new HashSet<>()).contains(ch)==true || cols.getOrDefault(j,new HashSet<>()).contains(ch)==true || squares.getOrDefault(((3*(i/3))+(j/3)),new HashSet<>()).contains(ch)==true )
                            return false;
                        rows.computeIfAbsent(i,k->new HashSet<Character>()).add(ch);
                        cols.computeIfAbsent(j,k->new HashSet<Character>()).add(ch);
                        squares.computeIfAbsent((3*(i/3))+(j/3),k->new HashSet<Character>()).add(ch);

                }
            }
        }
        return true;
    }
}