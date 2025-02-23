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
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            inMap.put(inorder[i],i);
        }
        TreeNode root = helper(postorder,0,postorder.length-1,inorder,0,inorder.length-1,inMap);
        return root;
    }
    
    public TreeNode helper(int[] postorder, int poststart, int postend, int[] inorder,int instart, int inend, HashMap<Integer, Integer> inMap)
    {
        if(poststart>postend || instart>inend)
            return null;
        
        int inRoot = inMap.get(postorder[postend]);
        TreeNode root = new TreeNode(postorder[postend]);
        int numsleft = inRoot-instart;
        root.left = helper(postorder,poststart,numsleft+poststart-1,inorder,instart,inRoot-1,inMap);
        root.right = helper(postorder,poststart+numsleft,postend-1,inorder,inRoot+1,inend,inMap);
        return root;

    }
}