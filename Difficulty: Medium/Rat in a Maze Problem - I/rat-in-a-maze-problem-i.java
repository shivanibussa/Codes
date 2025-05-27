class Solution 
{
    public ArrayList<String> ratInMaze(int[][] maze) 
    {
        int n = maze.length;
        int visited[][] = new int[n][n];
        ArrayList<String>res = new ArrayList<>();
        int dr[] = new int[]{1,0,0,-1};
        int dc[] = new int[]{0,-1,1,0};
        if(maze[0][0]==1){
            visited[0][0] = 1;
            f(maze,n,visited,res,"",dr,dc,0,0);
        }
            
        return res;
    }
    public void f(int maze[][],int n,int visited[][],ArrayList<String>res,String s,int dr[],int dc[],int r,int c)
    {
        if(r==n-1 && c==n-1)
        {
            res.add(s);
            return;
        }
        
        String str = "DLRU";
        for(int i=0;i<4;i++)
        {
            int nr = dr[i]+r;
            int nc = dc[i]+c;
            
            if(nr>=0 && nr<n && nc>=0 && nc<n && maze[nr][nc]==1 && visited[nr][nc]==0)
            {
                visited[nr][nc]=1;
                f(maze,n,visited,res,s+str.charAt(i),dr,dc,nr,nc);
                visited[nr][nc]=0;
            }
        }
    }
}