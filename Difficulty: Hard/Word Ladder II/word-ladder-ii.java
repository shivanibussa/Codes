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
    public ArrayList<ArrayList<String>> findSequences(String startWord, String endWord,
                                                                        String[] wordList) 
    {
        HashSet<String> hs = new HashSet<>();
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        Queue<ArrayList<String>> q = new LinkedList<>();
        q.add(ls);
        int level=0;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        
        for(int i=0;i<wordList.length;i++)
            hs.add(wordList[i]);
        
        while(!q.isEmpty())
        {
            ArrayList<String> al = q.poll();
            if(al.size()>level)
            {
                level++;
                for(String it:usedOnLevel)
                {
                    hs.remove(it);
                }
                
            }
            String word = al.get(al.size()-1);
            if(word.equals(endWord))
            {
                if(ans.size()==0)
                {
                    ans.add(al);
                }
                else if(ans.get(0).size()==al.size())
                {
                    ans.add(al);
                }
            }
            
            for(int i=0;i<word.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char chars[] = word.toCharArray();
                    chars[i] = ch;
                    String nw = new String(chars);
                    if(hs.contains(nw))
                    {
                        ArrayList<String> temp = new ArrayList<>(al);
                        temp.add(nw);
                        q.add(temp);
                        usedOnLevel.add(nw);
                    }
                }
            }
        }
        return ans;
    }
}