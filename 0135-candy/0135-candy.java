class Solution 
{
    public int candy(int[] ratings) 
    {
        int n = ratings.length;
        int left[] = new int[n];
        int right = 0;
        left[0] = 1;
        int candy=0;
        for(int i=1;i<n;i++)
        {
            if(ratings[i]>ratings[i-1])
                left[i] = 1+left[i-1];
            else
                left[i] = 1;
        }
         candy+=left[n-1];
        right = 1;
        int cur=0;
        for(int i=n-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
            {
                cur = 1+right;
                
            }
            else
                cur = 1;
            right = cur;
            candy +=Math.max(left[i],cur);
        }
        return candy;
    }
}