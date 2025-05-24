class Pair
{
    String word;
    int steps;
    Pair(String word,int steps)
    {
        this.word = word;
        this.steps = steps;
    }
}
class Solution 
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        HashSet<String> hs = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,0));
        for(String w:wordList)
            hs.add(w);
        hs.remove(beginWord);

        while(!q.isEmpty())
        {
            Pair pop = q.poll();
            String rw = pop.word;
            int steps = pop.steps;
            if(rw.equals(endWord))
                return steps+1;
            for(int i=0;i<rw.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char chs[] = rw.toCharArray();
                    chs[i] = ch;
                    String nw = new String(chs);
                    if(hs.contains(nw))
                    {
                        q.add(new Pair(nw,steps+1));
                        hs.remove(nw);
                    }
                }
            }
        }
        return 0;
    }
}