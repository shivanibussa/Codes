// User function Template for Java

class Solution 
{
    static int knapSack(int val[], int wt[], int W) 
    {
        int n = val.length;
        int dp[][] = new int[n][W+1];
        for(int j=0;j<=W;j++)
        {
            if(j>=wt[0])
                dp[0][j] = val[0]*(j/wt[0]);
            else
                dp[0][j] = 0;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=W;j++)
            {
                int take = Integer.MIN_VALUE;
                int not_take =dp[i-1][j];
                if(j>=wt[i])
                    take = val[i]+dp[i][j-wt[i]];
                    
                dp[i][j] = Math.max(take,not_take);
            
            }
        }
        return dp[n-1][W];
    }
    static int f(int val[],int wt[],int capacity,int ind)
    {
        if(ind==0)
        {
            if(capacity>=wt[0])
                return val[0]*(capacity/wt[0]);
            else
                return 0;
        }
        int take = Integer.MIN_VALUE;
        int not_take = f(val,wt,capacity,ind-1);
        if(capacity>=wt[ind])
            take = val[ind]+f(val,wt,capacity-wt[ind],ind);
            
        return Math.max(take,not_take);
    }
}