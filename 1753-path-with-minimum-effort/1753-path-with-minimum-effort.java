class Solution 
{
    public int minimumEffortPath(int[][] A) 
    {
        PriorityQueue<int[]>q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int m = A.length, n = A[0].length;
        int X = m-1, Y = n-1;
        int dist[][] = new int[m][n];
        int dr[] = new int[]{-1,0,1,0};
        int dc[] = new int[]{0,-1,0,1};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dist[i][j] = (int)1e9;
            }
        }
        dist[0][0] = 0;
        q.add(new int[]{0,0,0});
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int a = pop[1], b = pop[2], wt = pop[0];
            if(a==X&&b==Y)
                return wt;
            for(int k=0;k<4;k++)
            {
                int nr = a+dr[k];
                int nc = b+dc[k];
                
                if(nr>=0 && nr<m && nc>=0 && nc<n)
                {
                    int newEffort = Math.max(wt,Math.abs(A[nr][nc]-A[a][b]));
                    if(newEffort<dist[nr][nc])
                    {
                        dist[nr][nc] = newEffort;
                        q.offer(new int[]{dist[nr][nc],nr,nc});
                    }
                }
            }
        }
        
        return -1;

    }
}