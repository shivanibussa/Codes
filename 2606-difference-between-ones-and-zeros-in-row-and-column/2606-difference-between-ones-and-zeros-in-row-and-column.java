class Solution 
{
    public int[][] onesMinusZeros(int[][] grid) 
    {
        int m = grid.length,n=grid[0].length;
        int row1[] = new int[m];
        int row0[] = new int[m];
        int col1[] = new int[n];
        int col0[] = new int[n];
        int diff[][] = new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                row1[i]+=grid[i][j];
                if(grid[i][j]==0)
                {
                    row0[i]+=1;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                col1[i] += grid[j][i];
                if(grid[j][i]==0)
                {
                    col0[i] +=1;
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                diff[i][j] = row1[i]+col1[j]-(row0[i]+col0[j]);
            }
        }
        for(int i=0;i<m;i++)
            System.out.println(row1[i]+" "+row0[i]);
        for(int j=0;j<n;j++)
            System.out.println(col1[j]+" "+col0[j]);
        return diff;
       
    }
}