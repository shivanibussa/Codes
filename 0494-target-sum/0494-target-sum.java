class Solution 
{
    public int findTargetSumWays(int[] arr, int target) 
    {
        int sum = 0;
        for(int n:arr)
            sum+=n;
        if((sum-target)%2!=0 || sum-target<0)
            return 0;
        int tar = (sum-target)/2;
        int n = arr.length;
        int dp[][] = new int[n][tar+1];

        for(int i=0;i<n;i++)
            dp[i][0] = 1;
        
        if(arr[0]<=tar)
            dp[0][arr[0]] = 1;
        
        if(arr[0]==0)
            dp[0][0]=2;

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=tar;j++)
            {
                int take = 0;
                int not_take = dp[i-1][j];
                if(j>=arr[i])
                    take = dp[i-1][j-arr[i]];

                dp[i][j] = (take+not_take);
            }
        }
        return dp[n-1][tar];
    }
}