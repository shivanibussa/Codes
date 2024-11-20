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
    public List<Integer> preorderTraversal(TreeNode root)
    {
        ArrayList<Integer> al = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                al.add(curr.val);
                curr = curr.right;
            }
            else
            {
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr)
                {
                    prev = prev.right;
                }
                if(prev.right==null)
                {
                    prev.right = curr;
                    al.add(curr.val);
                    curr = curr.left;
                }
                else
                {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return al;
    }
}