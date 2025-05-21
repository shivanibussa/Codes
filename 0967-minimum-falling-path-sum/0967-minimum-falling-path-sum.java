class Solution 
{
    public int minFallingPathSum(int[][] matrix) 
    {
        int m = matrix.length, n = matrix[0].length,min = Integer.MAX_VALUE;
        int dp[][] = new int[m][n];

        for(int j=0;j<n;j++)
        {
            dp[0][j] = matrix[0][j];
        }

        for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int up = dp[i-1][j],ld = Integer.MAX_VALUE,rd = Integer.MAX_VALUE;
                if(j-1>=0)
                    ld = dp[i-1][j-1];
                if(j+1<=n-1)
                    rd = dp[i-1][j+1];
                dp[i][j] = matrix[i][j]+Math.min(up,Math.min(ld,rd));
            }
        }
        for(int j=0;j<n;j++)
        {
            min = Math.min(min,dp[m-1][j]);
        }
        return min;
    }

    public int f(int i,int j,int matrix[][])
    {
        int m = matrix.length, n = matrix[0].length;
        if(i<0 || j<0 ||i>m-1 || j>n-1)
            return Integer.MAX_VALUE;

        if(i==0)
            return matrix[i][j];

        int up = f(i-1,j,matrix);
        int ld = f(i-1,j-1,matrix);
        int rd = f(i-1,j+1,matrix);

        return matrix[i][j]+Math.min(up,Math.min(ld,rd));

    }
}
