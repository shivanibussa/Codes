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

class Solution 
{
    public List<Integer> rightSideView(TreeNode root) 
    {
       Queue<TreeNode> q = new LinkedList<>();
       ArrayList<Integer> res = new ArrayList<>();
       if(root==null)
        return res;
       q.add(root);

       while(!q.isEmpty())
       {
            int s = q.size();
            ArrayList<Integer> al = new ArrayList<>();
            for(int i=0;i<s;i++)
            {
                TreeNode pop = q.poll();
                al.add(pop.val);
                if(pop.left!=null)
                {
                    q.add(pop.left);
                }
                if(pop.right!=null)
                {
                    q.add(pop.right);
                }
            }
            res.add(al.get(al.size()-1));
       } 
       return res;
    }
}