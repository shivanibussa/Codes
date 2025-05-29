class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        ArrayList<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int n = intervals.length;
        for(int i=1;i<n;i++)
        {
            if(res.get(res.size()-1)[1]>=intervals[i][0])
            {
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],intervals[i][1]);
            }
            else
            res.add(intervals[i]);
        }
        return res.toArray(new int [res.size()][]);
    }
}