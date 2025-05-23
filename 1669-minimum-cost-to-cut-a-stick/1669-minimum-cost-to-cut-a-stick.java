class Solution 
{
    public int minCost(int n, int[] cuts) 
    {
        int c = cuts.length;
        int newC[] = new int[c+2];
        System.arraycopy(cuts,0,newC,1,c);
        newC[0]=0;
        newC[c+1]=n;
        Arrays.sort(newC);
        int dp[][] = new int[c+2][c+2];

        for(int i=c;i>=1;i--)
        {
            for(int j=1;j<=c;j++)
            {
                if(i>j){
                    continue;
                }
                int mini= Integer.MAX_VALUE;
                for(int k=i;k<=j;k++)
                {
                    int cutss = newC[j+1]-newC[i-1]+dp[i][k-1]+dp[k+1][j];
                    mini = Math.min(mini,cutss);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][c];
    }
    public int f(int newC[],int i,int j)
    {
        if(i>j)
            return 0;
        int mini = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++)
        {
            int cuts = newC[j+1]-newC[i-1]+(f(newC,i,k-1)+f(newC,k+1,j));
            mini = Math.min(mini,cuts);
        }
        return mini;
    }
}