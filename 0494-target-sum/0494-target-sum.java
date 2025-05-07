class Solution 
{
    public int findTargetSumWays(int[] arr, int target) 
    {
        int sum=0,n=arr.length;
        for(int no:arr)
            sum+=no;
        int s = (sum-target)/2;
        if( (sum-target)<0 || (sum-target)%2==1)
			return 0;
        int dp[][] = new int[n][s+1];
        for(int i=0;i<n;i++)
			dp[i][0] = 1;
		if (arr[0] == 0)
            dp[0][0] = 2;
        else if (arr[0] <= s)
            dp[0][arr[0]] = 1;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=s;j++)
            {
                int not_take = dp[i-1][j];
                int take = 0;
                if(j>=arr[i])
                    take = dp[i-1][j-arr[i]];

                dp[i][j] = take+not_take;
            }
        }
        return dp[n-1][s];
    }
}