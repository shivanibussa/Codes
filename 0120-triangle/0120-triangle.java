class Solution 
{
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        
        for(int i=0;i<n;i++)
        {
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--)
        {
            for(int j=i;j>=0;j--)
            {
                int down = dp[i+1][j];
                int diagonal = dp[i+1][j+1];
                dp[i][j] = triangle.get(i).get(j)+Math.min(down,diagonal);
            }
        }
        return dp[0][0];
    }
    public int f(List<List<Integer>> triangle, int i,int j)
    {
        int n = triangle.size();
        if(i==n-1)
            return triangle.get(i).get(j);

        int down = triangle.get(i).get(j);
        int diagonal = triangle.get(i).get(j);

        if(i+1<n)
            down+=f(triangle,i+1,j);
        if(i+1<n && j+1<n)
            diagonal+=f(triangle,i+1,j+1);

        return Math.min(down,diagonal);
    }
}