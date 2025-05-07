class Solution 
{
    public int maxProfit(int[] prices) 
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
                    temp[j] = Math.max(-prices[i]+dp[0],dp[1]);
                }
                else
                {
                    temp[j] = Math.max(prices[i]+dp[1],dp[0]);
                }
            }
            dp=temp;
        }
        return dp[1];
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