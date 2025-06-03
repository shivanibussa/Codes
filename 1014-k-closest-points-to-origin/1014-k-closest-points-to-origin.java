class Solution 
{
    public int[][] kClosest(int[][] points, int k) 
    {
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int point[]:points)
        {
            int x = point[0],y=point[1];
            int dist = (x*x) + (y*y);
            pq.offer(new int[]{dist,x,y});
        }

        int res[][] = new int[k][2];
        for(int i=0;i<k;i++)
        {
            int triplet[] = pq.poll();
            res[i][0] = triplet[1];
            res[i][1] = triplet[2];
        }
        return res;
    }
}