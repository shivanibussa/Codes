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
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root==null)
            return res;
        
        q.add(root);
        boolean check = false;
        while(!q.isEmpty())
        {
            int l = q.size();
            ArrayList<Integer> al = new ArrayList<>();
            for(int i=0;i<l;i++)
            {
                TreeNode node = q.poll();
                if(node.left!=null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
                 al.add(node.val);
            }
           if (check) {
                Collections.reverse(al); // Corrected here
            }
            
            res.add(al);
            check = !check; 
        }
        return res;
        
    }
}