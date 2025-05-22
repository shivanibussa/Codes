class Solution 
{
    public int findContentChildren(int[] greed, int[] sizes) 
    {
        Arrays.sort(greed);
        Arrays.sort(sizes);
        int l=0, m=greed.length, r=0, n=sizes.length;
        while(l<m && r<n)
        {
            if(greed[l]<=sizes[r])
            {
                l++;
                r++;
            }
            else
            {
                r++;
            }
        }
        return l;
    }
}