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
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        TreeNode curr= root;
        ArrayList<Integer> arr = new ArrayList<>();
        while(curr!=null)
        {
            if(curr.left==null)
            {
                arr.add(curr.val);
                curr = curr.right;
            }
            else
            {
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr)
                {
                    prev=prev.right;
                }
                if(prev.right!=null)
                {
                    arr.add(prev.right.val);
                    prev.right=null;
                    curr = curr.right;
                }
                else
                {
                    prev.right=curr;
                    curr = curr.left;
                }
            }
        }
        return arr;
    }
}