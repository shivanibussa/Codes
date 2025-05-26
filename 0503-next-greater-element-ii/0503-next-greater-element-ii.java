class Solution 
{
    public int[] nextGreaterElements(int[] nums) 
    {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums[i]>=st.peek())
                st.pop();

            st.push(nums[i]);
        }
        for(int i=nums.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums[i]>=st.peek())
                st.pop();
            ans[i] = !st.isEmpty()?st.peek():-1;
            st.push(nums[i]);
        }
        return ans;
    }
}