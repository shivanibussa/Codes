class Solution 
{
    public int maxCoins(int[] nums)
    {
        int n = nums.length;
        int newnums[] = new int[n+2];
        System.arraycopy(nums,0,newnums,1,n);
        newnums[0] = 1;
        newnums[n+1] = 1;
        // return f(newnums,1,n);
        int dp[][] = new int[n+2][n+2];
        for(int i=n;i>=1;i--)
        {
            
            for(int j=1;j<=n;j++)
            {
                if(i>j)
                    continue;
                int max = Integer.MIN_VALUE;
                for(int k=i;k<=j;k++)
                {
                    int points = newnums[i-1]*newnums[k]*newnums[j+1]+dp[i][k-1]+dp[k+1][j];
                    max = Math.max(max,points);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n];
    }
    public int f(int newnums[],int i,int j)
    {
        if(i>j)
            return 0;
        int maxi = Integer.MIN_VALUE;
        for(int k = i;k<=j;k++)
        {
            int points = newnums[i-1]*newnums[k]*newnums[j+1]+f(newnums,i,k-1)+f(newnums,k+1,j);
            maxi = Math.max(maxi,points);
        }
        return maxi;   
        }
}