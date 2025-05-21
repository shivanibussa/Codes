class Solution 
{
    public int minFallingPathSum(int[][] matrix) 
    {
        int m = matrix.length, n = matrix[0].length,min = Integer.MAX_VALUE;
        int dp[] = new int[n];

        for(int j=0;j<n;j++)
        {
            dp[j] = matrix[0][j];
        }

        for(int i=1;i<m;i++)
        {
            int temp[] = new int[n];
            for(int j=0;j<n;j++)
            {
                int up = dp[j],ld = Integer.MAX_VALUE,rd = Integer.MAX_VALUE;
                if(j-1>=0)
                    ld = dp[j-1];
                if(j+1<=n-1)
                    rd = dp[j+1];
                temp[j] = matrix[i][j]+Math.min(up,Math.min(ld,rd));
            }
            dp = temp;
        }
        for(int j=0;j<n;j++)
        {
            min = Math.min(min,dp[j]);
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
