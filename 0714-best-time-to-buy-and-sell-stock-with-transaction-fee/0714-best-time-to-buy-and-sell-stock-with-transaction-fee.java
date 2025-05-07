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
                    temp[j] = Math.max(-prices[i]+dp[0],0+dp[1]);
                }
                else
                {
                    temp[j] = Math.max(prices[i]+dp[1]-fee,0+dp[0]);
                }
            }
            dp = temp;
        }
        return dp[1];
    }
}