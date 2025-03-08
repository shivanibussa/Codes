//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       
System.out.println("~");
}
    }
}

// } Driver Code Ends

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
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<wordList.length;i++)
        {
            hs.add(wordList[i]);
        }
        hs.remove(startWord);
        q.add(new Pair(startWord,1));
        while(!q.isEmpty())
        {
            Pair pop = q.poll();
            String s = pop.word;
            int step = pop.steps;
            if(s.equals(targetWord))
            {
                return step;
            }
            for(int i=0;i<s.length();i++)
            {
                for(char c='a';c<='z';c++)
                {
                    char chrs[] = s.toCharArray();
                    chrs[i] = c;
                    String news = new String(chrs);
                    if(hs.contains(news))
                    {
                        q.add(new Pair(news,step+1));
                        hs.remove(news);
                    }
                }
            }
        }
        return 0;
    }
}