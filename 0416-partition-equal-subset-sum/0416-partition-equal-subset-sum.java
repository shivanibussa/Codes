class Solution 
{
    public boolean canPartition(int[] arr) 
    {
        int sum=0,n=arr.length;
		for(int i=0;i<n;i++)
			sum+=arr[i];
		if(sum%2!=0)
			return false;
		
		int k = sum/2;
		boolean dp[][] = new boolean[n][k+1];
		for(int i=0;i<n;i++)
			dp[i][0] = true;

		if(arr[0]<=k)
			dp[0][arr[0]] = true;

		for(int i=1;i<n;i++)
		{
			for(int target=1;target<=k;target++)
			{
				boolean not_take = dp[i-1][target];
				boolean take = false;

				if(arr[i]<=target)
					take = dp[i-1][target-arr[i]];

				dp[i][target] = take || not_take;
			}
		}
		return dp[n-1][k];
    }
}