class Solution 
{
    public int maxSumAfterPartitioning(int[] arr, int k) 
    {
        int n = arr.length;
        int dp[] = new int[n+1];
        
        for(int i=n-1;i>=0;i--)
        {
            int len=0,max = Integer.MIN_VALUE,maxP=0;
            for(int j=i;j<Math.min(i+k,n);j++)
            {
                len++;
                max = Math.max(max,arr[j]);
                int points = (max*len)+dp[j+1];
                maxP = Math.max(maxP,points);
            }
            dp[i] = maxP;
        }
        return dp[0];
    }
    public int f(int arr[],int i,int k)
    {
        int n = arr.length;
        int len=0,max = Integer.MIN_VALUE,maxP=0;
        for(int j=i;j<Math.min(i+k,n);j++)
        {
            len++;
            max = Math.max(max,arr[j]);
            int points = (max*len)+f(arr,j+1,k);
            maxP = Math.max(maxP,points);
        }
        return maxP;
    }
}