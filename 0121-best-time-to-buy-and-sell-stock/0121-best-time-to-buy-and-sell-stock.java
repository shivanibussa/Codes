class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int maxP=0,min=prices[0];
        for(int i=1;i<prices.length;i++)
        {
            min = Math.min(min,prices[i]);
            maxP = Math.max(maxP,prices[i]-min);
        }
        return maxP;
    }
}