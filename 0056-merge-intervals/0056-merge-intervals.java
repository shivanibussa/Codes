class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]>res = new ArrayList<>();
        res.add(intervals[0]);
        for(int i=1;i<n;i++)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start<=res.get(res.size()-1)[1])
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],end);
            else
                res.add(intervals[i]);
        }
        return res.toArray(new int[res.size()][2]);
    }
}