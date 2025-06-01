class Node
{
    Node links[]= new Node[26];
    boolean flag = false;

    public Node get(char ch)
    {
        return links[ch-'a'];
    }
    public void put(char ch,Node node)
    {
        links[ch-'a'] = node;
    }
    public boolean containsKey(char ch)
    {
        return links[ch-'a']!=null;
    }
    public void setEnd()
    {
        flag=true;
    }
    public void unsetEnd()
    {
        flag=false;
    }
    public boolean isEnd()
    {
        return flag;
    }
}
class Solution 
{
    public Node root = new Node();
    public List<String> findWords(char[][] board, String[] words) 
    {
        for(String w:words)
        {
            insert(w);
        }
        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                dfs(board,i,j,root,new StringBuilder(),res);
            }
        }
        return res;
    }

    public void dfs(char board[][],int r,int c,Node node,StringBuilder sb,ArrayList<String>res)
    {
        int rows = board.length,cols=board[0].length;
        if(r<0 || r==rows || c<0 || c==cols ||board[r][c]=='#' || node.containsKey(board[r][c])==false)
            return;

        

        char ch = board[r][c];
        board[r][c] = '#';
        node = node.get(ch);
        sb.append(ch);

        if(node.isEnd())
        {
            res.add(sb.toString());
            node.unsetEnd();
        }

        dfs(board,r+1,c,node,sb,res);
        dfs(board,r,c+1,node,sb,res);
        dfs(board,r,c-1,node,sb,res);
        dfs(board,r-1,c,node,sb,res);
        board[r][c] = ch;
        sb.deleteCharAt(sb.length()-1);
    }

    public void insert(String word)
    {
        Node curr = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(!curr.containsKey(ch))
            {
                curr.put(ch,new Node());
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
}