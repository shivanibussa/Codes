class Solution 
{
    public boolean canPartition(int[] arr) 
    {
        int sum =0;
        for(int n:arr)
            sum+=n;
        if(sum%2!=0)
            return false;
        sum = sum/2;

        int n = arr.length;
        boolean dp[][] = new boolean[n][sum+1];

        for(int i=0;i<n;i++)
        {
            dp[i][0] = true;
        }
        if(arr[0]<=sum)
            dp[0][arr[0]]=true;

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                boolean take = false;
                boolean not_take = dp[i-1][j];
                if(j>=arr[i])
                    take = dp[i-1][j-arr[i]];
                
                dp[i][j] = take||not_take;
            }
        }
        return dp[n-1][sum];
    }
}