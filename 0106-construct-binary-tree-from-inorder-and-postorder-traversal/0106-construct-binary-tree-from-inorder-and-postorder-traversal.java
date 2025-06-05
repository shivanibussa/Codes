class Solution 
{
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        HashMap<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            inMap.put(inorder[i],i);
        }
        int n = postorder.length;
        return helper(0,n-1,inorder,0,n-1,postorder,inMap);
    }
    public TreeNode helper(int is,int ie,int inorder[],int ps,int pe,int postorder[],HashMap<Integer,Integer> hm) 
    {
        if(ps>pe || is>ie)
            return null;
        int inRoot = hm.get(postorder[pe]);
        int numsLeft = inRoot-is;
        TreeNode root = new TreeNode(postorder[pe]);
        root.left = helper(is,inRoot-1,inorder,ps,ps+numsLeft-1,postorder,hm);
        root.right = helper(inRoot+1,ie,inorder,ps+numsLeft,pe-1,postorder,hm);
        return root;
    }
}