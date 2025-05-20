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
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = postorder.length;
        for(int i=0;i<n;i++)
        {
            hm.put(inorder[i],i);
        }

        return helper(postorder,0,n-1,inorder,0,n-1,hm);
    }

    public TreeNode helper(int postorder[],int ps,int pe,int inorder[],int is,int ie,HashMap<Integer,Integer> hm)
    {
        if(ps>pe || is>ie)
            return null;
        
        TreeNode root = new TreeNode(postorder[pe]);
        int inroot = hm.get(root.val);
        int numsLeft = inroot-is;
        root.left = helper(postorder,ps,ps+numsLeft-1,inorder,is,inroot-1,hm);
        root.right = helper(postorder,ps+numsLeft,pe-1,inorder,inroot+1,ie,hm);
        return root;
    }
}