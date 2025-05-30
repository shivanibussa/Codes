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
        for(String w:wordList)
            hs.add(w);
        hs.remove(beginWord);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty())
        {
            Pair pop = q.poll();
            String word = pop.word;
            int steps = pop.steps;
            // if(word.equals(endWord))
            //     return steps+1;
            for(int i=0;i<word.length();i++)
            {
                for(char c='a';c<='z';c++)
                {
                    char chas[] = word.toCharArray();
                    chas[i] = c;
                    String nw = new String(chas);
                    if(hs.contains(nw))
                    {
                        if(nw.equals(endWord))
                        return steps+1;
                        hs.remove(nw);
                        q.offer(new Pair(nw,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}