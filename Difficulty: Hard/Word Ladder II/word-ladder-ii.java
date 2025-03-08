//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b) {
        String x = "";
        String y = "";
        for (int i = 0; i < a.size(); i++) x += a.get(i);
        for (int i = 0; i < b.size(); i++) y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for (int i = 0; i < n; i++) {
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans =
                obj.findSequences(startWord, targetWord, wordList);
            if (ans.size() == 0)
                System.out.println(-1);
            else {
                Collections.sort(ans, new comp());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ans.size(); i++) {
                    for (int j = 0; j < ans.get(i).size(); j++) {
                        sb.append(ans.get(i).get(j) + " ");
                    }
                    if (i != ans.size() - 1) sb.append("\n");
                }
                System.out.println(sb);
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord,
                                                      String[] wordList)
    {
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ArrayList<String> usedOnLevel = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        
        ls.add(startWord);
        usedOnLevel.add(startWord);
        q.add(ls);
        
        for(int i=0;i<wordList.length;i++)
            hs.add(wordList[i]);
            
        int level=0;
        while(!q.isEmpty())
        {
            ArrayList<String> al = q.poll();
            {
                if(level<al.size())
                {
                    level++;
                    for(String w: usedOnLevel)
                    {
                        hs.remove(w);
                    }
                }
            }
            String w = al.get(al.size()-1);
            if(w.equals(targetWord))
            {
                if(res.size()==0)
                {
                    res.add(new ArrayList<>(al));
                }
                else if(res.get(0).size()==al.size())
                {
                    res.add(new ArrayList<>(al));
                }
            }
            for(int i=0;i<w.length();i++)
            {
                for(char c='a';c<='z';c++)
                {
                    char chs[] = w.toCharArray();
                    chs[i] = c;
                    String news = new String(chs);
                    
                    if(hs.contains(news))
                    {
                        ArrayList<String> temp = new ArrayList<>(al);
                        temp.add(news);
                        q.add(temp);
                        usedOnLevel.add(news);
                    }
                }
            }
        }
        
        return res;
        
    }
}