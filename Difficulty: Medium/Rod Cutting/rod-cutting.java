class Solution 
{
    public int cutRod(int[] price) 
    {
        int n = price.length;
        int dp[][] = new int[n][n+1];
        
        for(int j=0;j<=n;j++)
        {
            dp[0][j] = j*price[0];
        }
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                int take = Integer.MIN_VALUE;
                int not_take = dp[i-1][j];
                if(j>=(i+1))
                    take = price[i]+dp[i][j-(i+1)];
                    
                dp[i][j] = Math.max(take,not_take);
            }
        }
        return dp[n-1][n];
    }
    public int f(int price[],int L,int ind)
    {
        if(ind==0)
        {
            return L*price[0];
        }
        
        int not_take = f(price,L,ind-1);
        int take = Integer.MIN_VALUE;
        if(L>=(ind+1))
            take = price[ind]+f(price,L-(ind+1),ind);
            
        return Math.max(take,not_take);
    }
}