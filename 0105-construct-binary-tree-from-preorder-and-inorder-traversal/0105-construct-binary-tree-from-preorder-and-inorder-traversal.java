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
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = inorder.length;
        for(int i=0;i<n;i++)
            hm.put(inorder[i],i);

        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,hm);
    }
    public TreeNode buildTree(int preorder[],int prestart,int prend,int inorder[],int instart,int inend, HashMap<Integer,Integer> hm )
    {
        if(prestart>prend || instart>inend)
            return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int inn = hm.get(root.val);
        int numsleft = inn-instart;
        root.left = buildTree(preorder,prestart+1,prestart+numsleft,inorder,instart,inn-1,hm);
        root.right = buildTree(preorder,prestart+numsleft+1,prend,inorder,inn+1,inend,hm);

        return root;
    }
}