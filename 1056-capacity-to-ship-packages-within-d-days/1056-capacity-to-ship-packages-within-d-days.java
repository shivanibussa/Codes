class Solution 
{
    public int shipWithinDays(int[] weights, int days) 
    {
        int sum =0, n =weights.length, maxE = 0;
        for(int i=0;i<n;i++)
        {
            sum+=weights[i];
            maxE = Math.max(maxE,weights[i]);
        }

        int l = maxE, r = sum;
        while(l<=r)
        {
            int mid = l+(r-l)/2;
            if(f(weights,mid)<=days)
            {
                r = mid-1;
            }
            else
            {
                l = mid+1;
            }
        }
        return l;
    }

    public int f(int weights[],int cap)
    {
        int load =0,days =1;
        for(int w:weights)
        {
            if(load+w>cap)
            {
                days++;
                load=0;
            }
            load+=w;
        }
        return days;
    }
}