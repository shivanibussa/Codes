class Node
{
    Node links[] = new Node[2];
    boolean flag = false;

    public boolean containsKey(int bit)
    {
        return links[bit]!=null;
    }

    public void put(int bit,Node node)
    {
        links[bit] = node;
    }

    public Node get(int bit)
    {
        return links[bit];
    }
}

class Trie
{
    Node root;

    Trie()
    {
        root = new Node();
    }

    public void insert(int num)
    {
        Node node = root;
        for(int i=31;i>=0;i--)
        {
            int bit = (num >>i)&1;
            if(!node.containsKey(bit))
            {
                node.put(bit,new Node());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int num)
    {
        Node node = root;
        int maxNum =0;
        for(int i=31;i>=0;i--)
        {
            int bit = (num >> i) &1;
            if(node.containsKey(1-bit))
            {
                maxNum = maxNum | (1<<i);
                node = node.get(1-bit);
            }
            else
            {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
} 
class Solution {
    public int findMaximumXOR(int[] nums) 
    {
        Trie trie = new Trie();
        for(int i=0;i<nums.length;i++)
        {
            trie.insert(nums[i]);
        } 
        int maxNum=0;
        for(int i=0;i<nums.length;i++)
        {
            maxNum = Math.max(maxNum,trie.getMax(nums[i]));
        }

        return maxNum;
    }
}