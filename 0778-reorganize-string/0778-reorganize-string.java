class Solution 
{
    public String reorganizeString(String s) 
    {
        HashMap<Character,Integer>hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray())
        {
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
    
    PriorityQueue<Character>pq = new PriorityQueue<>((a,b)->hm.get(b)-hm.get(a));
    pq.addAll(hm.keySet());

    while(pq.size()>1)
    {
        Character curr = pq.poll();
        Character next = pq.poll();
        sb.append(curr);
        sb.append(next);
        hm.put(curr,hm.get(curr)-1);
        hm.put(next,hm.get(next)-1);
        if(hm.get(curr)>0)
            pq.add(curr);
        if(hm.get(next)>0)
            pq.add(next);
    }

    if(pq.size()==1)
    {
        char ch = pq.poll();
        if(hm.get(ch)>1)
            return "";
        else
        {
            sb.append(ch);
        }
    }
    return sb.toString();
    }
}