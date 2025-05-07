class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int mini = prices[0],maxP=0;
        for(int i=1;i<prices.length;i++)
        {
            mini = Math.min(mini,prices[i]);
            maxP = Math.max(maxP,prices[i]-mini);
        }
        return maxP;
    }
}