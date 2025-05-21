class Solution 
{
    public boolean canPartition(int[] arr) 
    {
        int n = arr.length,sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
        }
        if(sum%2!=0)
            return false;
        sum = sum/2;
        boolean dp[] = new boolean[sum+1];
        for(int i=0;i<n;i++)
            dp[0] = true;
        if(arr[0]<=sum)
            dp[arr[0]] = true;

        for(int i=1;i<n;i++)
        {
            boolean temp[] = new boolean[sum+1];
            temp[0] = true;
            for(int j=1;j<=sum;j++)
            {
                boolean take = false;
                boolean not_take = dp[j];
                if(j>=arr[i])
                    take = dp[j-arr[i]];

                temp[j] = take||not_take;
            }
            dp = temp;
        }
        return dp[sum];
    }
}