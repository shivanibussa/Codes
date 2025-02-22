import java.util.*;
import java.util.Arrays;
class Solution 
{
    public int lengthOfLIS(int[] nums) 
    {
        ArrayList<Integer> subsequence = new ArrayList<>();
        for(int num:nums)
        {
            int idx = Collections.binarySearch(subsequence,num);
            if(idx<0)
            {
                idx = -(idx+1);
            }
            if(idx<subsequence.size())
            {
                subsequence.set(idx,num);
            }
            else
                subsequence.add(num);
        }
        return subsequence.size();
    }
}