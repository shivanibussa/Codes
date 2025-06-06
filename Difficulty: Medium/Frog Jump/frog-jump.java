class Solution
{
    int minCost(int[] height)
    {
        int n = height.length;
        int dp[] = new int[n];
        dp[0] =0;
        
        for(int i=1;i<height.length;i++)
        {
            int one = Math.abs(height[i]-height[i-1])+dp[i-1];
            int two = Integer.MAX_VALUE;
            if(i-2>=0)
                two = Math.abs(height[i]-height[i-2])+dp[i-2];
            
            dp[i] = Math.min(one,two);
        }
        return dp[n-1];
    }
    int f(int n,int height[])
    {
        if(n>=height.length-1)
            return 0;
        int two = Integer.MAX_VALUE;
        int one = Math.abs(height[n]-height[n+1])+f(n+1,height);
        if(n+2<height.length)
            two = Math.abs(height[n]-height[n+2])+f(n+2,height);
        
        return Math.min(one,two);
    }
}