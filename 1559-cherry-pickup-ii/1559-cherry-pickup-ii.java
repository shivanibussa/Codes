class Solution 
{
    public int cherryPickup(int[][] grid) 
    {
        int r = grid.length,c=grid[0].length;
        int dp[][][] = new int[r][c][c];
        for(int j1=0;j1<c;j1++)
        {
            for(int j2=0;j2<c;j2++)
            {
                if(j1==j2)
                    dp[r-1][j1][j2] = grid[r-1][j1];
                else
                    dp[r-1][j1][j2] = grid[r-1][j1]+grid[r-1][j2];
            }
        }

        for(int i=r-2;i>=0;i--)
        {
            for(int j1=0;j1<c;j1++)
            {
                for(int j2=0;j2<c;j2++)
                {
                    int max = -(int)1e8;
                    for(int dj1=-1;dj1<=1;dj1++)
                    {
                        for(int dj2=-1;dj2<=1;dj2++)
                        {
                            int val =0 ;
                            if(j1==j2)
                                val=grid[i][j1];
                            else
                            {
                                val = grid[i][j1]+grid[i][j2];
                            }
                            if(j1+dj1>=0 && j2+dj2>=0 && j1+dj1<c && j2+dj2<c)
                                val+=dp[i+1][j1+dj1][j2+dj2];
                            else
                                val = -(int)1e8;
                            max = Math.max(max,val);
                        }
                    }
                    dp[i][j1][j2]= max;
                }
            }
        }
           return dp[0][0][c-1];
    }
 
}