class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        int n1 = nums1.length, n2 = nums2.length;
        int ans[] = new int[n2];
        int res[] = new int[n1];
        Stack<Integer> st = new Stack();
        for(int i=n2-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums2[i]>=st.peek())
                st.pop();

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }
        for(int i=0;i<n1;i++)
        {
            for(int j=0;j<n2;j++)
            {
                if(nums2[j] == nums1[i])
                {
                    res[i] = ans[j];
                    break;
                }
            }
        }
        return res;
    }
}