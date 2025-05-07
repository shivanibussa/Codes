class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int n = prices.length;
        int dp[][] = new int[n+1][2];

        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<2;j++)
            {
                if(j==1)
                {
                    dp[i][j] = Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }
                else
                {
                    dp[i][j] = Math.max(prices[i]+dp[i+1][1],dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }
    public int f(int prices[],int buy,int i)
    {
        if(i==prices.length)
            return 0;
        int profit=0;
        if(buy==1)
        {
            profit = Math.max(-prices[i]+f(prices,0,i+1),0+f(prices,1,i+1));
        }
        else
        {
            profit = Math.max(prices[i]+f(prices,1,i+1),0+f(prices,0,i+1));
        }

        return profit;
    }
}