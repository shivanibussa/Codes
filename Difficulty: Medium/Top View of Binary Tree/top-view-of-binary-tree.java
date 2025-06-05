/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Pair
{
    Node node;
    int axis;
    
    Pair(Node node ,int axis)
    {
        this.node = node;
        this.axis = axis;
    }
}
class Solution 
{
    static ArrayList<Integer> topView(Node root) 
    {
    
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty())
        {
            Pair pop = q.poll();
            Node node = pop.node;
            int line = pop.axis;
            
            if(!tm.containsKey(line))
            {
                tm.put(line,node.data);
            }
            if(node.left!=null)
                q.add(new Pair(node.left,line-1));
            if(node.right!=null)
                q.add(new Pair(node.right,line+1));
        }
        for(int v:tm.values())
        {
            res.add(v);
        }
        return res;
    }
}