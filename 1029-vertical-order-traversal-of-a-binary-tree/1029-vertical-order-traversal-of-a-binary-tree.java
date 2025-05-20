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
    int row,col;

    Pair(TreeNode node,int row,int col)
    {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
class Solution 
{
    public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> hm = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0,0));

        while(!q.isEmpty())
        {
            Pair pop = q.poll();
            TreeNode node = pop.node;
            int x = pop.row, y = pop.col;

            hm.computeIfAbsent(x,k-> new TreeMap<>());
            hm.get(x).computeIfAbsent(y,k-> new ArrayList<>());
            hm.get(x).get(y).add(node.val);

            if(node.left!=null)
            {
                q.add(new Pair(node.left,x-1,y+1));
            }
            if(node.right!=null)
            {
                q.add(new Pair(node.right,x+1,y+1));
            }
        }
        for(TreeMap<Integer,ArrayList<Integer>> tm : hm.values())
        {
            ArrayList<Integer> temp = new ArrayList<>();
            for(ArrayList<Integer> es: tm.values())
            {
                Collections.sort(es);
                temp.addAll(es);            
            }
            res.add(temp);
        }
        return res;
    }
}