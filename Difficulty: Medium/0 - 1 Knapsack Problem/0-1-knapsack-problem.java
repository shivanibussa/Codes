class Solution 
{
    static int knapsack(int W, int val[], int wt[])
    {

        int n = wt.length;
        int dp[][] = new int[n][W+1];
        
        for(int j=0;j<=W;j++)
        {
            if(j>=wt[0])
                dp[0][j] = val[0];
            else 
                dp[0][j]= 0;
        }
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=W;j++)
            {
                int take = Integer.MIN_VALUE;
                int not_take = dp[i-1][j];
                if(j>=wt[i])
                    take = val[i]+dp[i-1][j-wt[i]];
                    
                dp[i][j] = Math.max(take,not_take);
            }
        }
        
        return dp[n-1][W];
    }
    static int f(int n,int val[],int wt[],int W)
    {
        if(n==0)
        {
            if(W>=wt[n])
                return val[n];
            else
                return 0;
        }
        
        int take = Integer.MIN_VALUE;
        int not_take = f(n-1,val,wt,W);
        if(W>=wt[n])
            take = val[n]+f(n-1,val,wt,W-wt[n]);
        
        return Math.max(take,not_take);
    }
}
