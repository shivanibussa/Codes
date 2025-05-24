// User function Template for Java

class Solution 
{
    int minimumMultiplications(int[] arr, int start, int end) 
    {
        if(start==end)
            return 0;
        int dist[] = new int[100000];
        for(int i=0;i<100000;i++)
        {
            dist[i] = (int)1e9;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,start});
        dist[start] = 0;
        int mod = 100000;
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int steps = pop[0], v = pop[1];
            for(int i=0;i<arr.length;i++)
            {
                int pro = (v*arr[i])%mod;
                if(dist[pro]>1+steps)
                {
                    dist[pro] = 1+steps;
                    if(pro==end)
                        return dist[pro];
                        
                    q.add(new int[]{dist[pro],pro});
                }
            }
        }
        return -1;
    }
}
