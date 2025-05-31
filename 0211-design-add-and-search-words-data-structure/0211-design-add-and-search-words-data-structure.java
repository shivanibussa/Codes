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
class WordDictionary
{
    private Node root;
    public WordDictionary() 
    {
        root = new Node();
    }
    public void addWord(String word)
    {
        Node node = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(!node.containsKey(ch))
            {
                node.put(ch,new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    public boolean search(String word)
    {
        return searchIndex(word,0,root);
    }
    public boolean searchIndex(String word,int ind,Node node)
    {
        if(ind==word.length())
            return node.isEnd();

        char ch = word.charAt(ind);
        if(ch=='.')
        {
            for(int i=0;i<26;i++)
            {
                if(node.links[i]!=null)
                {
                    if(searchIndex(word,ind+1,node.links[i]))
                        return true;
                }
            }
            return false;
        }
        else 
        {
            if(!node.containsKey(ch))
            {
                return false;
            }
            else
                return searchIndex(word,ind+1,node.get(ch));
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */