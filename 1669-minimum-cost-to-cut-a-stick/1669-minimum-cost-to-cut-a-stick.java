class Solution 
{
    public int minCost(int n, int[] cuts) 
    {
        int c = cuts.length;
        int[] newCuts = new int[c+2];
        System.arraycopy(cuts,0,newCuts,1,c);
        newCuts[0]=0;
        newCuts[c+1] = n;
        Arrays.sort(newCuts);
        int dp[][] = new int[c+2][c+2];

        for(int i=c;i>=1;i--)
        {
            for(int j=1;j<=c;j++)
            {
                if(i>j)
                    continue;

                int min = Integer.MAX_VALUE;

                for(int k=i;k<=j;k++)
                {
                    int cost = newCuts[j+1]-newCuts[i-1]+dp[i][k-1]+dp[k+1][j];
                    min = Math.min(cost,min);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][c];
    }
    public int f(int i,int j,int cuts[])
    {
        if(i>j)
            return 0;
        int mini = Integer.MAX_VALUE;
        for(int ind = i;ind<=j;ind++)
        {
            int cost = cuts[j+1]-cuts[i-1]+f(i,ind-1,cuts)+f(ind+1,j,cuts);
            mini = Math.min(mini,cost);
        }
        return mini;
    }
}