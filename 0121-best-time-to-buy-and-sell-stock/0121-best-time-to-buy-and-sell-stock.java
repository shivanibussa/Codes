class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int n = prices.length;
        int min = prices[0],max=0;
        for(int i=1;i<n;i++)
        {
            min = Math.min(min,prices[i]);
            max = Math.max(max,prices[i]-min);
        }
        return max;
    }
}