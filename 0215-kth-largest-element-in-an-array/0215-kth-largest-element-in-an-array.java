class Solution 
{
    public int findKthLargest(int[] nums, int k) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int n = nums.length;
        for(int i=0;i<n;i++)
            pq.offer(nums[i]);
        int i=0;
        System.out.println(pq.toString());
        while(i<k-1)
        {
            pq.poll();
            i=i+1;
        }
        return pq.peek();

    }
}