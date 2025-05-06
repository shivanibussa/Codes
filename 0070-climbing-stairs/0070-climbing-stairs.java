class Solution 
{
    public int climbStairs(int n) 
    {
        //int dp[] = new int[n+1];
        int prev2 = 1;
        int prev1 = 1,curr = 0;
        for(int i=2;i<n+1;i++)
        {
            curr = prev1+prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int f(int n)
    {
        if(n==0)
            return 1;

        if(n==1)
            return 1;

        return f(n-1)+f(n-2);
    }
}