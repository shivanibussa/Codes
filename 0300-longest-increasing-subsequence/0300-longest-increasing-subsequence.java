import java.util.*;
import java.util.Arrays;
class Solution
{
    public int lengthOfLIS(int[] arr) 
    {
        ArrayList<Integer> al = new ArrayList<>();
        for(int num:arr)
        {
            int idx = Collections.binarySearch(al,num);
            if(idx<0)
            {
                idx = -(idx+1);
            }
            if(idx<al.size())
                al.set(idx,num);
            else
                al.add(num);
        }
        return al.size();
    }
}