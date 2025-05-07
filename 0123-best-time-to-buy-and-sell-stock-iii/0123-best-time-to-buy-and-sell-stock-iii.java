class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int n = prices.length;
        int dp[][][] = new int [n+1][2][3];
        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<2;j++)
            {
                for(int k=2;k>0;k--)
                {
                    if(j==1)
                        dp[i][j][k] = Math.max(-prices[i]+dp[i+1][0][k],0+dp[i+1][1][k]);
                    else
                        dp[i][j][k] = Math.max(prices[i]+dp[i+1][1][k-1],0+dp[i+1][0][k]);
                }
            }
        }
        return dp[0][1][2];
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