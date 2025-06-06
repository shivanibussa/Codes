class Solution 
{
    public int minFallingPathSum(int[][] mat)
    {
        int minS = Integer.MAX_VALUE;
        int n = mat.length;
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            dp[0][i] = mat[0][i];
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int up = Integer.MAX_VALUE,ld=Integer.MAX_VALUE,rd=Integer.MAX_VALUE;
                if(j-1>=0)
                    ld = dp[i-1][j-1];
                if(j+1<=n-1)
                    rd = dp[i-1][j+1];

                up = dp[i-1][j];
                dp[i][j] = mat[i][j]+Math.min(up,Math.min(ld,rd));
            }
        }
        for(int i=0;i<n;i++)
        {
            minS = Math.min(minS,dp[n-1][i]);
        }
        return minS;
    }
    public int f(int mat[][],int i,int j)
    {
        if(i<0 || j<0 || i>mat.length-1 || j>mat.length-1)
            return Integer.MAX_VALUE;
        if(i==0)
            return mat[i][j];

        int up = f(mat,i-1,j);
        int ld = f(mat,i-1,j-1);
        int rd = f(mat,i-1,j+1);

        return mat[i][j]+Math.min(up,Math.min(ld,rd));
    }
}