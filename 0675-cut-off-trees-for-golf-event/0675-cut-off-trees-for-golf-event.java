class Solution 
{
    public int cutOffTree(List<List<Integer>> forest) 
    { 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int m = forest.size(), n = forest.get(0).size();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(forest.get(i).get(j)!=1 && forest.get(i).get(j)!=0)
                {
                    pq.offer(new int[]{forest.get(i).get(j),i,j});
                }
            }
        }
        int totSteps=0;
        int start_x = 0,start_y=0;

        while(!pq.isEmpty())
        {
            int pop[] = pq.poll();
            int h = pop[0], x=pop[1],y=pop[2];
            int steps = bfs(x,y,start_x,start_y,forest);
            if(steps==-1)
                return -1;
            totSteps+=steps;
            start_x = x;
            start_y = y;
        }
        return totSteps;
    }

    public int bfs(int ex,int ey,int sx,int sy,List<List<Integer>> forest)
    {
        Queue<int[]>q = new LinkedList<>();
        q.offer(new int[]{0,sx,sy});
        int dr[] = new int[]{-1,0,1,0};
        int dc[] = new int[]{0,-1,0,1};
        int m = forest.size(), n = forest.get(0).size();
        int visited[][] = new int[m][n];
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int steps = pop[0],r=pop[1],c=pop[2];
            if(r==ex && c==ey)
                return steps;

            for(int k=0;k<4;k++)
            {
                int nr = r+dr[k];
                int nc = c+dc[k];

                if(nr>=0 && nr<m && nc>=0 && nc<n && visited[nr][nc]==0 && forest.get(nr).get(nc)!=0)
                {
                    q.offer(new int[]{steps+1,nr,nc});
                    visited[nr][nc]=1;
                }
            }
        }
        return -1;
    }
}