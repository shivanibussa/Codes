class Solution 
{
    public int maxProfit(int[] prices, int fee) 
    {
        int n = prices.length;
        int dp[] = new int[2];
        for(int i=n-1;i>=0;i--)
        {
            int temp[] = new int[2];
            for(int j=0;j<2;j++)
            {
                if(j==1)
                {
                    int take = -prices[i]+dp[0];
                    int not_take = dp[1];
                    temp[j] = Math.max(take,not_take);
                }
                else
                {
                    int sell = prices[i]+dp[1];
                    int not_sell = dp[0];
                    temp[j] = Math.max(sell-fee,not_sell);
                }
            }
            dp = temp;
        }
        return dp[1];

    }
}