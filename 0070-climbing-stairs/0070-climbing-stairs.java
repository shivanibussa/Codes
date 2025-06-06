class Solution 
{
    public int climbStairs(int n) 
    {
        int dp[] = new int[n+1];
        int prev=1;
        int prev2=1;
        for(int i=2;i<=n;i++)
        {
            int curr = prev+prev2;
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public int f(int n)
    {
        if(n<=1)
            return 1;

        return f(n-1)+f(n-2);
    }
}