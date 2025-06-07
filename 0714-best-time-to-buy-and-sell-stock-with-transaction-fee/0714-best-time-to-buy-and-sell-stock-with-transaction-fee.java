class Solution 
{
    public int maxProfit(int[] prices, int fee) 
    {
        int n=prices.length;
        int dp[][]= new int[n+1][2];
        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<2;j++)
            {
                if(j==1)
                {
                    int take = -prices[i]+dp[i+1][0];
                    int not_take = 0+dp[i+1][1];
                    dp[i][j] = Math.max(take,not_take);
                }
                else
                {
                    int sell = prices[i]+dp[i+1][1]-fee;
                    int not_sell = 0+dp[i+1][0];
                    dp[i][j] = Math.max(sell,not_sell);
                }
            }
        }
        return dp[0][1];
    }
}