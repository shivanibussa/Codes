class Twitter {
    private HashMap<Integer,List<int[]>> Tweets;
    private HashMap<Integer,Set<Integer>> Followers;
    private int count;

    public Twitter() 
    {
        count = 0;
        Tweets = new HashMap<>();
        Followers = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) 
    {
        Tweets.putIfAbsent(userId, new ArrayList<>());
        Tweets.get(userId).add(new int[]{count--, tweetId});

    }
    
    public List<Integer> getNewsFeed(int userId) 
    {
        List<Integer> res = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>
        (Comparator.comparingInt(a -> a[0]));

        Followers.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for(int followeeid:Followers.get(userId))
        {
            if(Tweets.containsKey(followeeid))
            {
                int index = Tweets.get(followeeid).size()-1;
                int []tweets = Tweets.get(followeeid).get(index);
                pq.offer(new int[]{tweets[0],tweets[1],followeeid,index});
            }
        }

        while(!pq.isEmpty() && res.size()<10)
        {
            int curr[] = pq.poll();
            res.add(curr[1]);
            int index = curr[3];
            if(index>0)
            {
                int tweet[] = Tweets.get(curr[2]).get(index-1);
                pq.offer(new int[]{tweet[0],tweet[1],curr[2],index-1});
            }
        }
        return res;

    }
    
    public void follow(int followerId, int followeeId) 
    {
       Followers.computeIfAbsent(followerId,k-> new HashSet<>()).add
       (followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) 
    {
        HashSet<Integer> al = new HashSet<>(Followers.getOrDefault(followerId,new HashSet<>()));
        if(al.size()!=0)
            al.remove(followeeId);
        Followers.put(followerId, al);

    }
}
