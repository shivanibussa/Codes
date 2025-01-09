class Solution 
{
    public boolean isNStraightHand(int[] hand, int groupSize) 
    {
       if(hand.length%groupSize!=0)
            return false;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int h:hand)
        {
            hm.put(h,hm.getOrDefault(h,0)+1);
        }
        PriorityQueue<Integer>pq = new PriorityQueue<>(hm.keySet());
        while(!pq.isEmpty())
        {
            int f = pq.peek();
            for(int i=f;i<f+groupSize;i++)
            {
                if(hm.getOrDefault(i,0)==0)
                    return false;
                hm.put(i,hm.get(i)-1);
                if(hm.get(i)==0)
                {
                    if(i!=pq.peek())
                        return false;
                    pq.poll();
                }
            }
        }
        return true;
    }
}