class Solution 
{
    public int maxProfit(int k, int[] prices) 
    {
        int n = prices.length;
        int dp[][] = new int[2][k+1];
        for(int j=0;j<2;j++)
            dp[j][0] = 0;
        
        for(int j=0;j<2;j++)
            for(int cap=0;cap<=k;cap++)
                dp[j][cap]=0;

        for(int i=n-1;i>=0;i--)
        {
            int curr[][] = new int[2][k+1];
            for(int j=0;j<2;j++)
            {
                for(int cap=1;cap<=k;cap++)
                {
                    if(j==1)
                    {
                        curr[j][cap] = Math.max(-prices[i]+dp[0][cap],dp[1][cap]);
                    }
                    else
                    {
                        curr[j][cap] = Math.max(prices[i]+dp[1][cap-1],dp[0][cap]);
                    }
                }
            }
            dp = curr;
        }
        return dp[1][k];
    }
}