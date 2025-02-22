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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)
            return res;
        q.add(root);
        int cnt=0;
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode pop = q.poll();
                temp.add(pop.val);
                if(pop.left!=null)
                    q.add(pop.left);
                if(pop.right!=null)
                    q.add(pop.right);
            }
            cnt++;
            if(cnt%2==0)
                Collections.reverse(temp);
            res.add(temp);
        }
        return res;
    }
}