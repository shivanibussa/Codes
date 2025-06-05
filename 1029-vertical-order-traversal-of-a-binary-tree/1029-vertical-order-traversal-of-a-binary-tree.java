import java.util.*;
class Pair
{
    TreeNode node;
    int haxis;
    int axis;

    Pair(TreeNode node,int haxis, int axis)
    {
        this.node = node;
        this.haxis = haxis;
        this.axis = axis;
    }
}
class Solution 
{
    public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> tm = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0,0));

        while(!q.isEmpty())
        {
            Pair pop = q.poll();
            TreeNode node = pop.node;
            int line = pop.axis;
            int hline = pop.haxis;

            tm.putIfAbsent(hline,new TreeMap<>());
            tm.get(hline).putIfAbsent(line,new ArrayList<>());
            tm.get(hline).get(line).add(node.val);

            if(node.left!=null)
                q.add(new Pair(node.left,hline-1,line+1));
            if(node.right!=null)
                q.add(new Pair(node.right,hline+1,line+1));
        }
        Collection<TreeMap<Integer, ArrayList<Integer>>> tmv = tm.values();
        for(TreeMap<Integer,ArrayList<Integer>> entry:tmv)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            for(ArrayList<Integer> al:entry.values())
            {
                Collections.sort(al);
                temp.addAll(al);
            }
            res.add(temp);
        }
        System.out.println(tm);
        return res;
    }
}