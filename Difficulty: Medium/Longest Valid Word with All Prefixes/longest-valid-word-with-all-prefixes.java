//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String line = sc.nextLine();
            if (line.trim().isEmpty()) {
                System.out.println(); // Empty string case
                System.out.println("~");
                continue;
            }

            String[] words = line.trim().split("\\s+");
            Solution sol = new Solution();
            String result = sol.longestValidWord(words);
            System.out.println(result);
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends

class Node
{
    Node links[] = new Node[26];
    boolean flag = false;
    
    public boolean containsKey(char ch)
    {
        return links[ch-'a']!=null;
    }
    
    public Node get(char ch)
    {
        return links[ch-'a'];
    }
    
    public void put(char ch,Node node)
    {
        links[ch-'a'] = node;
    }
    
    public void setEnd()
    {
        flag = true;
    }
    
    public boolean isEnd()
    {
        return flag;
    }
}
class Trie
{
    private static Node root; 
    public Trie() 
    {
        root = new Node();
    }

    public void insert(String word) 
    {
        Node node = root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.containsKey(word.charAt(i)))
            {
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean checkPrefix(String w)
    {
         Node node = root;
         boolean flag = true; 
        for(int i=0;i<w.length();i++)
        {
            if(node.containsKey(w.charAt(i)))
            {
                node = node.get(w.charAt(i));
                flag = flag && node.isEnd(); 
            }
            else
            {
                return false;
            }
        }
        return flag;
    }

}
class Solution 
{
    Trie obj = new Trie();
    
    String longest=""; 
    public String longestValidWord(String[] words) 
    {
        for(String w:words)
        {
            obj.insert(w);
        }
        
        for(String w:words)
        {
            if(obj.checkPrefix(w))
            {
                if(w.length()>longest.length() || (w.length()== longest.length() && w.compareTo(longest)<0))
                {
                    longest = w;
                }
            }
        }
        return longest;
    }
}