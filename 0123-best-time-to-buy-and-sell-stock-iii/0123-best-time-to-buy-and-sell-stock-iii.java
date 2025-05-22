class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int n = prices.length;
        int dp[][] = new int[2][3];
        for(int i=n-1;i>=0;i--)
        {
            int temp[][] = new int[2][3];
            for(int j=0;j<2;j++)
            {
                for(int k=2;k>0;k--)
                {
                    if(j==1)
                    {
                        temp[j][k] = Math.max(-prices[i]+dp[0][k],0+dp[1][k]);
                    }
                    else
                    {
                        temp[j][k] = Math.max(prices[i]+dp[1][k-1],dp[0][k]);
                    }
                }
            }
            dp = temp;
        }
        return dp[1][2];
    }
    public int f(int prices[],int ind,int buy,int cap)
    {
        if(ind==prices.length)
            return 0;

        if(cap==0)
            return 0;

        if(buy==1)
            return Math.max(-prices[ind]+f(prices,ind+1,0,cap),f(prices,ind+1,1,cap));
        return Math.max(prices[ind]+f(prices,ind+1,1,cap-1),f(prices,ind+1,0,cap));
    }
}