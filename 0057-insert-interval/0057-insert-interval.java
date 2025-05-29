class Solution 
{
    public int[][] insert(int[][] intervals, int[] newInterval) 
    {
        int i=0;
        ArrayList<int[]>res = new ArrayList<>();
        int n = intervals.length;
        while(i<n && intervals[i][1]<newInterval[0])
        {
                res.add(intervals[i]);
                i=i+1;
        }
        while(i<n && intervals[i][0]<=newInterval[1])
        {
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i=i+1;
        }
        res.add(newInterval);
        while(i<n)
        {
            res.add(intervals[i]);
            i=i+1;
        }
        return res.toArray(new int[res.size()][2]);
    }
}