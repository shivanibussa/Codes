class Solution 
{
    public boolean lemonadeChange(int[] bills) 
    {
        int ten =0,f=0,n=bills.length;
        for(int i=0;i<n;i++)
        {
            if(bills[i]==5)
                f+=1;
            else if(bills[i]==10)
            {
                if(f>=1)
                {
                    f-=1;
                    ten+=1;
                }
                else
                    return false;
            }
            else
            {
                if(ten>=1 && f>=1)
                {
                    ten-=1;
                    f-=1;
                }
                else if(f>=3)
                {
                    f-=3;
                }
                else
                    return false;
            }
        }
        return true;
    }
}