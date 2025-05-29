
class Solution 
{
    static int solve(int bt[]) 
    {
        Arrays.sort(bt);
        int t=0, wT=0, n=bt.length;
        for(int i=0;i<n;i++)
        {
            wT+=t;
            t+=bt[i];
        }
        return (wT/n);
    }
}
