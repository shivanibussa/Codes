class Solution 
{
    public int maxProfit(int k, int[] prices) 
    {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][k+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<2;j++)
                dp[i][j][0] = 0;
        
        for(int j=0;j<2;j++)
            for(int cap=0;cap<=k;cap++)
                dp[0][j][cap]=0;

        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<2;j++)
            {
                for(int cap=1;cap<=k;cap++)
                {
                    if(j==1)
                    {
                        dp[i][j][cap] = Math.max(-prices[i]+dp[i+1][0][cap],dp[i+1][1][cap]);
                    }
                    else
                    {
                        dp[i][j][cap] = Math.max(prices[i]+dp[i+1][1][cap-1],dp[i+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}