class Solution 
{
    public int maximumPoints(int arr[][]) 
    {
        int n = arr.length;
        int dp[][] = new int[n][4];
        dp[0][0] = Math.max(arr[0][1],arr[0][2]);
        dp[0][1] = Math.max(arr[0][0],arr[0][2]);
        dp[0][2] = Math.max(arr[0][1],arr[0][0]);
        dp[0][3] = Math.max(arr[0][0],Math.max(arr[0][1],arr[0][2]));
        
        for(int day=1;day<n;day++)
        {
            
            for(int last=0;last<=3;last++)
            {
                int maxP=0;
                for(int i=0;i<3;i++)
                {
                    if(i!=last)
                    {
                        maxP = Math.max(maxP,dp[day-1][i]+arr[day][i]);
                    }
                    
                }
                dp[day][last] = maxP;
            }
            
        }
        
        return dp[n-1][3];
    }
    public int f(int arr[][],int day,int last)
    {
        int maxP=0;
        if(day==0)
        {
            for(int i=0;i<3;i++)
            {
                if(i!=last)
                    maxP = Math.max(maxP,arr[day][i]);
            }
        }
        else
        {
            for(int i=0;i<3;i++)
            {
                if(i!=last)
                {
                    maxP = Math.max(maxP,f(arr,day-1,i)+arr[day][i]);
                }
            }
        }
        return maxP;
    }
}