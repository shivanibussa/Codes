class Solution 
{
    public double findMedianSortedArrays(int[] A, int[] B) 
    {
        int n1 = A.length, n2 = B.length;
        int total = (n1+n2+1);
        int half = (n1+n2+1)/2;
        if(n1>n2)
        {
            int temp[] = A;
            A = B;
            B = temp;
        }
        int l = 0,r=A.length;
        while(l<=r)
        {
            int i = (l+r)/2;
            int j = half-i;

            int Aleft = i>0?A[i-1]:Integer.MIN_VALUE;
            int Aright = i<A.length ? A[i]:Integer.MAX_VALUE;
            int Bleft = j>0?B[j-1]:Integer.MIN_VALUE;
            int Bright = j<B.length?B[j]:Integer.MAX_VALUE;

            if(Aleft<=Bright && Bleft<=Aright)
            {
                if((n1+n2)%2!=0)
                {
                    return Math.max(Aleft,Bleft);
                }
                else
                {
                    return ((Math.max(Aleft,Bleft)+Math.min(Aright,Bright))/2.00);
                }
            }
            else if(Aleft>Bright)
            {
                r=i-1;
            }
            else
            {
                l=i+1;
            }
        }
        return -1;
    }
}