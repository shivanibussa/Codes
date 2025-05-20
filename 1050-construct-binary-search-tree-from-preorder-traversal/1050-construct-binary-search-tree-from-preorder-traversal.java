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
    int index=0;
    public TreeNode bstFromPreorder(int[] preorder) 
    {
        return helper(preorder,Integer.MAX_VALUE);
    }

    public TreeNode helper(int preorder[],int bound)
    {
        if(index==preorder.length || preorder[index]>bound)
            return null;
        TreeNode curr = new TreeNode(preorder[index++]);
        curr.left = helper(preorder,curr.val);
        curr.right = helper(preorder,bound);

        return curr;
    }
}