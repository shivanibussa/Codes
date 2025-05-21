class Solution 
{
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        int n = triangle.size();
        int dp[][] = new int[n][n];

        for(int j=0;j<n;j++)
        {
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--)
        {
            for(int j=i;j>=0;j--)
            {
                int down = Integer.MAX_VALUE, diag = Integer.MAX_VALUE;
                if(i+1<n)
                    down = dp[i+1][j];
                if(i+1<n && j+1<n)
                    diag = dp[i+1][j+1];

                dp[i][j] = Math.min(down,diag)+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
    public int f(int i,int j,List<List<Integer>> triangle)
    {
        int n = triangle.size();
        if(i==n-1)
            return triangle.get(i).get(j);

        int down = triangle.get(i).get(j)+f(i+1,j,triangle);
        int diag = triangle.get(i).get(j)+f(i+1,j+1,triangle);
        return Math.min(down,diag);
    }
}