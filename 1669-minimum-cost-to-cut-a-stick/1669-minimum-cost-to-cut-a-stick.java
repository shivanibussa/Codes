class Solution 
{
    public int minCost(int n, int[] cuts) 
    {
        int c = cuts.length;
        int[] newCuts = new int[c + 2];
        System.arraycopy(cuts, 0, newCuts, 1, c);
        newCuts[0] = 0;
        newCuts[c + 1] = n;
        Arrays.sort(newCuts);
        int dp[][] = new int[c+2][c+2];
        for(int i=c;i>=1;i--)
        {
            for(int j=1;j<=c;j++)
            {
                if(i>j)
                    continue;
                int minCost = Integer.MAX_VALUE;
                for(int k=i;k<=j;k++)
                {
                    int cost = newCuts[j+1]-newCuts[i-1]+dp[i][k-1]+dp[k+1][j];
                    minCost = Math.min(cost,minCost);
                }
                dp[i][j] = minCost;
            }
        }
        return dp[1][c];
    }
}