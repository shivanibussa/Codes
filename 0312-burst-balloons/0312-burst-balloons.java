class Solution 
{
    public int maxCoins(int[] nums) 
    {
        int n = nums.length;
        int newN[] = new int[n+2];
        System.arraycopy(nums,0,newN,1,n);
        newN[0] = 1;
        newN[n+1] = 1;
        int dp[][] = new int[n+2][n+2];

        for(int i=n;i>=1;i--)
        {
          
            for(int j=0;j<=n;j++)
            {
                if(i>j)
                    continue;
                int maxi = Integer.MIN_VALUE;
                for(int k=i;k<=j;k++)
                {
                    int points = newN[i-1]*newN[k]*newN[j+1]+dp[i][k-1]+dp[k+1][j];
                    maxi = Math.max(maxi,points);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }
    public int f(int newN[],int i,int j)
    {
        if(i>j)
            return 0;
        
        int maxi = Integer.MIN_VALUE;
        for(int k=i;k<=j;k++)
        {
            int points = newN[i-1]*newN[k]*newN[j+1]+f(newN,i,k-1)+f(newN,k+1,j);
            maxi = Math.max(maxi,points);
        }
        return maxi;
    }
}