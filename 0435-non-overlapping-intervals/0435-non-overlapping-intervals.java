class Solution 
{
    public int eraseOverlapIntervals(int[][] intervals) 
    {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int n = intervals.length,res=0;
        int prevEnd = intervals[0][1];
        for(int i=1;i<n;i++)
        {
            if(prevEnd>intervals[i][0])
            {
                res++;
            }
            else
                prevEnd = intervals[i][1];
        }
        return res;
    }
}