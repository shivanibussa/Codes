class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int n=prices.length;
        int dp[][][] = new int[n+1][2][3];
        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<2;j++)
            {
                for(int k=2;k>0;k--)
                {
                    if(j==1)
                    {
                        int take = -prices[i]+dp[i+1][0][k];
                        int not_take = 0+dp[i+1][1][k];
                        dp[i][j][k] = Math.max(take,not_take);
                    }
                    else
                    {
                        int sell = prices[i]+dp[i+1][1][k-1];
                        int not_sell = 0+dp[i+1][0][k];
                        dp[i][j][k] = Math.max(sell,not_sell);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}