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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)
            return res;
        q.add(root);
        while(!q.isEmpty())
        {
            int s = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0;i<s;i++)
            {
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }    
            }
            res.add(temp);
        }
        return res;

    }
}