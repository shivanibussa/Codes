class Twitter 
{
    private HashMap<Integer,List<int[]>> tweetMap;
    private HashMap<Integer,HashSet<Integer>> followerMap;
    private int count;

    public Twitter() 
    {
        count=0;
        tweetMap = new HashMap<>();
        followerMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) 
    {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{count--,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) 
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        List<Integer> res = new ArrayList<>();

        followerMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for(int followeeId:followerMap.get(userId))
        {
            if(tweetMap.containsKey(followeeId))
            {
                int index = tweetMap.get(followeeId).size()-1;
                int tweets[] = tweetMap.get(followeeId).get(index);
                pq.offer(new int[]{tweets[0],tweets[1],followeeId,index});
            }
        }

        while(!pq.isEmpty() && res.size()<10)
        {
            int pops[] = pq.poll();
            res.add(pops[1]);
            int index = pops[3];
            if(index>0)
            {
                int tweet[] = tweetMap.get(pops[2]).get(index-1);
                pq.offer(new int[]{tweet[0],tweet[1],pops[2],index-1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) 
    {
        followerMap.putIfAbsent(followerId,new HashSet<>());
        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) 
    {
        followerMap.putIfAbsent(followerId,new HashSet<>());
        if(followerMap.get(followerId).size()!=0)
            followerMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */