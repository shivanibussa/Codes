class Pair
{
    int start,end;
    Pair(int start,int end)
    {
        this.start = start;
        this.end = end;
    }
}
class Solution 
{
    public int maxMeetings(int start[], int end[]) 
    {
        int n = start.length;
        Pair[] p = new Pair[n];
        for(int i=0;i<n;i++)
        {
            p[i] = new Pair(start[i],end[i]);
        }
        
        Arrays.sort(p,(a,b)->Integer.compare(a.end,b.end));
        int cnt =1;
        int prevEnd = p[0].end;
        for(int i=1;i<n;i++)
        {
            if(prevEnd<p[i].start)
            {
                prevEnd = p[i].end;
                cnt++;
            }
        }
        return cnt;
    }
}
