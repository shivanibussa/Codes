class Pair
{
    String word;
    int steps;
    Pair(String word, int steps)
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
        q.offer(new Pair(beginWord,1));
        hs.remove(beginWord);
        for(int i=0;i<wordList.size();i++)
        {
            hs.add(wordList.get(i));
        }
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            String w = p.word;
            int s = p.steps;
            if(w.equals(endWord))
            {
                return s;
            }
            for(int i=0;i<w.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char chars[] = w.toCharArray();
                    chars[i] = ch;
                    String nw = new String(chars);
                    if(hs.contains(nw))
                    {
                        q.offer(new Pair(nw,s+1));
                        hs.remove(nw);
                    }
                }
            }
        }
        return 0;
    }
}