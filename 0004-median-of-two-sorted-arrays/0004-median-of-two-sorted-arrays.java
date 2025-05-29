class Solution 
{
    public double findMedianSortedArrays(int[] A, int[] B) 
    {
        int a = A.length, b= B.length;
        int total = (a+b);
        int half = (a+b+1)/2;

        if(a>b)
        {
            int temp[] = A;
            A = B;
            B = temp;
        }

        int l =0, r=A.length;
        while(l<=r)
        {   
            int m1 = (l+r)/2;
            int m2 = half-m1;

            int Aleft = m1>0 ? A[m1-1]:Integer.MIN_VALUE;
            int Aright = m1<A.length ?A[m1]:Integer.MAX_VALUE;
            int Bleft = m2>0?B[m2-1]:Integer.MIN_VALUE;
            int Bright = m2<B.length?B[m2]:Integer.MAX_VALUE;

            if(Aleft<=Bright && Bleft<=Aright)
            {
                if((total%2)!=0)
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
                r = m1-1;
            }
            else
            {
                l = m1+1;
            }
            }
        return -1;
    }
}