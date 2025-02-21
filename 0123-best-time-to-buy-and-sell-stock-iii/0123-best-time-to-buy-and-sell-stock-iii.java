class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int n = prices.length;
        int dp[][] = new int[2][3];
        int profit=0;
        for(int i=n-1;i>=0;i--)
        {
            int temp[][] = new int[2][3];
            for(int j=0;j<2;j++)
            {
                for(int cap=1;cap<=2;cap++)
                {
                    if(j==1)
                    {
                        profit = Math.max(-prices[i]+dp[0][cap],dp[1][cap]);
                    }
                    else
                    {
                        profit = Math.max(prices[i]+dp[1][cap-1],dp[0][cap]);
                    }
                    temp[j][cap] = profit;
                }
                
            }
            dp=temp;
        }
        return dp[1][2];
    }
}