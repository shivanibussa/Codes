class Solution 
{
    public int trap(int[] height)
    {
        int l=0,r=height.length-1,res=0;
        int lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE;
        while(l<r)
        {
            if(height[l]<height[r])
            {
                if(lmax<=height[l])
                    lmax = height[l];
                else
                    res = res+(lmax-height[l]);
                l++;
            }
            else
            {
                if(rmax<=height[r])
                    rmax = height[r];
                else
                    res = res+(rmax-height[r]);
                r--;
            }
        }
        return res;
    }
}