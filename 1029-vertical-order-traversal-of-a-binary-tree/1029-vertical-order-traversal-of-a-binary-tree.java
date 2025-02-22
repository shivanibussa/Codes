/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair
{
    TreeNode node;
    int row;
    int col;
    Pair(TreeNode node,int row,int col)
    {
        this.node=node;
        this.row=row;
        this.col=col;
    }
}
class Solution 
{
    public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> tm = new TreeMap<>();
        Queue<Pair>q = new LinkedList<>();
        q.offer(new Pair(root,0,0));
        List<List<Integer>> res = new ArrayList<>();
        while(!q.isEmpty())
        {
            Pair pop = q.poll();
            TreeNode node = pop.node;
            int x = pop.row, y = pop.col;
            tm.computeIfAbsent(x, k -> new TreeMap<>());
            tm.get(x).computeIfAbsent(y,k->new ArrayList<>());
            tm.get(x).get(y).add(node.val);
            if(node.left!=null)
            {
                q.offer(new Pair(node.left,x-1,y+1));
            }
            if(node.right!=null)
            {
                q.offer(new Pair(node.right,x+1,y+1));
            }
        }
        for(TreeMap<Integer,ArrayList<Integer>> ys:tm.values())
        {
            ArrayList<Integer>temp = new ArrayList<>();
            for(ArrayList<Integer> vals:ys.values())
            {
                Collections.sort(vals);
                temp.addAll(vals);
            }
            res.add(temp);
        }
        return res;
    }
}