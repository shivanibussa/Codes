class Pair
{
    int id,deadline,profit;
    
    Pair(int id,int deadline,int profit)
    {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
class Solution 
{
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) 
    {
        int n = deadline.length;
        
        int maxD=-1;
        Pair[] p = new Pair[n];
        ArrayList<Integer> output = new ArrayList<>();
        int cnt=0,maxP=0;
        for(int i=0;i<n;i++)
        {
            p[i] = new Pair(i,deadline[i],profit[i]);
        }
        Arrays.sort(p,(a,b)->Integer.compare(b.profit,a.profit));
        for(int i=0;i<n;i++)
        {
            maxD = Math.max(maxD,deadline[i]);
        }
        int job[] = new int[maxD+1];
        for(int i=0;i<maxD+1;i++)
            job[i] = -1;
        
        for(int i=0;i<n;i++)
        {
            int d = p[i].deadline;
            for(int j=d;j>0;j--)
            {
                if(job[j]==-1)
                {
                    job[j] = i;
                    cnt+=1;
                    maxP+=p[i].profit;
                    break;
                }
            }
        }
        output.add(cnt);
        output.add(maxP);
        return output;
    }
}