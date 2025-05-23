class Solution 
{
    public int maxSumAfterPartitioning(int[] arr, int k) 
    {
        int n = arr.length;
        int dp[] = new int[n+1];
        for(int i=n-1;i>=0;i--)
        {
            int len=0,maxV=Integer.MIN_VALUE,maxAns = Integer.MIN_VALUE;
            for(int j=i;j<Math.min(i+k,n);j++)
            {
                len++;
                maxV = Math.max(maxV,arr[j]);
                int sum = (len*maxV)+dp[j+1];
                maxAns = Math.max(maxAns,sum);
            }
            dp[i] = maxAns;
        }
        return dp[0];
    }
    public int f(int arr[],int i,int k)
    {
        int n = arr.length;
        if(i==n)
            return 0;
        int len=0,maxV=Integer.MIN_VALUE,maxAns = Integer.MIN_VALUE;
        for(int j=i;j<Math.min(i+k,n);j++)
        {
            
        }
        return maxAns;
    }
}