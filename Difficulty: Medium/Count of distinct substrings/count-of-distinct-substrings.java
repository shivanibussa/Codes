//{ Driver Code Starts
import java.util.*;

class suffix
{
     int index;  
    int rank[] = new int[2];
}

class UniqueSubStr
{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            GfG g = new GfG();
            System.out.println(g.countDistinctSubstring(st));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*You are required to complete this method */
class Node
{
    Node links[] = new Node[26];
    boolean flag = true;
    
    public boolean containsKey(char ch)
    {
        return links[ch-'a']!=null;
    }
    
    public void put(char ch,Node node)
    {
        links[ch-'a'] = node;
    }
    
    public Node get(char ch)
    {
        return links[ch-'a'];
    }
}

class GfG 
{
    public static int countDistinctSubstring(String s) 
    {
        
        Node root = new Node();
        int n = s.length();
        int cnt=0;
        
        for(int i=0;i<n;i++)
        {
            Node node = root;
            for(int j=i;j<n;j++)
            {
                if(!node.containsKey(s.charAt(j)))
                {
                    cnt++;
                    node.put(s.charAt(j),new Node());
                }
                node = node.get(s.charAt(j));
            }
        }
        return cnt+1;
    }
}