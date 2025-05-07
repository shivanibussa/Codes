class Solution 
{
    public int minCut(String s) 
    {
        int n = s.length();
        int dp[] = new int[n+1];
        for(int i=n-1;i>=0;i--)
        {
            int mini = Integer.MAX_VALUE;
            for(int j=i;j<n;j++)
            {
                if(isPalindrome(i,j,s))
                {
                    int cost = 1+dp[j+1];
                    mini = Math.min(cost,mini);
                }
            }
            dp[i] = mini;
        }
        return dp[0]-1;
    }
    public int f(String s,int i,int n)
    {
        if(i==n)
            return 0;

        int mini = Integer.MAX_VALUE;
        for(int j=i;j<n;j++)
        {
            
            if(isPalindrome(i,j,s))
            {
                int cost = 1+f(s,j+1,n);
                mini = Math.min(cost,mini);
            }
        }
        return mini;
    }
    public boolean isPalindrome(int f,int e,String s)
    {
        while(f<e)
        {
            if(s.charAt(f)!=s.charAt(e))
            {
                return false;
            }
            f++;
            e--;
        }
        return true;
    }
}