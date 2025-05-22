class Solution 
{
    public int findTargetSumWays(int[] arr, int d) 
    {
        int sum=0,n=arr.length;
        for(int no:arr)
            sum+=no;

        if((sum-d)%2!=0 || sum-d<0)
            return 0;
        
        sum = (sum-d)/2;

        int dp[] = new int[sum+1];
        
        if(arr[0]<=sum)
            dp[arr[0]] = 1;
        
        dp[0] = (arr[0] == 0) ? 2 : 1;  
        for(int i=1;i<n;i++)
        {
            int temp[] = new int[sum+1];
            for(int j=0;j<=sum;j++)
            {
                int not_take = dp[j];
                int take= 0;
                if(j>=arr[i])
                    take = dp[j-arr[i]];
                    
                temp[j] = take+not_take;
            }
            dp = temp;
        }
        return dp[sum];

    }
}