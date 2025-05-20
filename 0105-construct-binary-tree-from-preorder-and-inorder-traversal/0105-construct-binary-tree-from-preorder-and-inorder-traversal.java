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
        for(int i=0;i<inorder.length;i++)
        {
            hm.put(inorder[i],i);
        }
        int n = preorder.length;
        return helper(inorder,0,n-1,preorder,0,n-1,hm);
    }
    public TreeNode helper(int inorder[],int is,int ie,int preorder[],int ps,int pe,HashMap<Integer,Integer> hm)
    {
        if(ps>pe || is>ie)
            return null;
        
        TreeNode root = new TreeNode(preorder[ps]);
        int inroot = hm.get(preorder[ps]);
        int numsLeft = inroot - is;
        root.left = helper(inorder,is,inroot-1,preorder,ps+1,ps+numsLeft,hm);
        root.right = helper(inorder,inroot+1,ie,preorder,ps+numsLeft+1,pe,hm);
        return root;
    } 
}