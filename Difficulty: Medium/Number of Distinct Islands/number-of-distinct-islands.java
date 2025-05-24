// User function Template for Java

class Solution 
{

    int countDistinctIslands(int[][] grid) 
    {
        int m = grid.length, n = grid[0].length;
        int visited[][] = new int[m][n];
        HashSet<ArrayList<String>> hs = new HashSet<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited[i][j]==0 && grid[i][j]==1)
                {
                    ArrayList<String> temp = new ArrayList<>();
                    bfs(i,j,visited,temp,grid,i,j);
                    hs.add(temp);
                }
            }
        }
        return hs.size();
        
    }
    
    public void bfs(int i,int j,int visited[][],ArrayList<String> temp, int grid[][],int r0,int c0)
    {
        int m = grid.length,n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = 1;
        int dr[] = new int[]{-1,0,1,0};
        int dc[] = new int[]{0,-1,0,1};
        
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int r = pop[0], c = pop[1];
            temp.add(toString(r-r0,c-c0));
            
            for(int k=0;k<4;k++)
            {
                
                int nr = r+dr[k];
                int nc = c+dc[k];
                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1 && visited[nr][nc]==0)
                {
                    q.add(new int[]{nr,nc});
                    visited[nr][nc]=1;
                }
                
            }
            
        }
    }
    public String toString(int a,int b)
    {
        return String.valueOf(a)+" "+String.valueOf(b);
    }
}
