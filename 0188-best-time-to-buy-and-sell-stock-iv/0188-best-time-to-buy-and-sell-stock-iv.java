class Solution 
{
    public int maxProfit(int ki, int[] prices) 
    {
        int n = prices.length;
        int dp[][] = new int [2][ki+1];
        for(int i=n-1;i>=0;i--)
        {
            int temp[][] = new int[2][ki+1];
            for(int j=0;j<2;j++)
            {
                for(int k=ki;k>0;k--)
                {
                    if(j==1)
                        temp[j][k] = Math.max(-prices[i]+dp[0][k],0+dp[1][k]);
                    else
                        temp[j][k] = Math.max(prices[i]+dp[1][k-1],0+dp[0][k]);
                }
            }
            dp = temp;
        }
        return dp[1][ki];
    }
    public int f(int prices[],int i,int buy,int cap)
    {
        if(i==prices.length)
            return 0;

        if(cap==0)
            return 0;

        int profit = 0;
        if(buy==1)
        {
            profit = Math.max(-prices[i]+f(prices,i+1,0,cap),0+f(prices,i+1,1,cap));
        }
        else
        {
            profit = Math.max(prices[i]+f(prices,i+1,1,cap-1),0+f(prices,i+1,0,cap));
        }

        return profit;
    }

}