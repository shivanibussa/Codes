// User function Template for Java

class Solution 
{

    public int minDifference(int arr[]) 
    {
        int sum=0;
        for(int n:arr)
            sum+=n;
        int n = arr.length;
        boolean dp[][] = new boolean[n][sum+1];
        for(int i=0;i<n;i++)
        {
            dp[i][0] = true;
        }
        if(arr[0]<=sum)
            dp[0][arr[0]] = true;
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                boolean take = false;
                boolean not_take = dp[i-1][j];
                if(j>=arr[i])
                    take = dp[i-1][j-arr[i]];
                    
                dp[i][j] = take||not_take;
            }
        }
        int mini = Integer.MAX_VALUE;
        for(int j=0;j<=sum;j++)
        {
            if(dp[n-1][j]==true)
            {
                int s1 = j;
                int s2 = sum-j;
                int diff = Math.abs(s1-s2);
                
                mini = Math.min(mini,diff);
            }
        }
        return mini;
    }
}
