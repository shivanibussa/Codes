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
    public boolean isSameTree(TreeNode p, TreeNode qn) 
    {
        if(p==null || qn==null)
            return p==qn;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(p);
        q.add(qn);
        while(!q.isEmpty())
        {
            TreeNode pop1 = q.poll();
            TreeNode pop2 = q.poll();

            if(pop1==null && pop2==null)
                continue;
            if(pop1==null ||pop2==null)
                return false;

            if(pop1.val!=pop2.val)
                return false;

            q.offer(pop1.left);
            q.offer(pop2.left);
            q.offer(pop1.right);
            q.offer(pop2.right);  
        }
        return true;
    }
}