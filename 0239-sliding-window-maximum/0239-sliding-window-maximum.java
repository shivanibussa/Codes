class Solution 
{
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        Deque<Integer> dq = new ArrayDeque<>();
        int ans[] = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++)
        {
            int ele = nums[i];
            if(!dq.isEmpty() && dq.peekFirst()<i-k+1)
                dq.pollFirst();

            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i])
            {
                dq.pollLast();
            }

            dq.offerLast(i);
            if(i-k+1>=0)
                ans[i-k+1] = nums[dq.peekFirst()];
        }
        return ans;
    }
}