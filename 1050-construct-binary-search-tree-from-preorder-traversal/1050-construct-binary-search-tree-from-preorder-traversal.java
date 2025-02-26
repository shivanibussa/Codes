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
class Solution {
    private int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreOrder(preorder, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreOrder(int[] preorder, int bound) {
        if (index == preorder.length || preorder[index] > bound)
            return null;
        
        TreeNode root = new TreeNode(preorder[index++]); // Use instance variable to track index
        root.left = bstFromPreOrder(preorder, root.val);
        root.right = bstFromPreOrder(preorder, bound);

        return root;
    }
}