class Solution 
{
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        HashMap<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            inMap.put(inorder[i],i);
        }
        int n = preorder.length;
        return helper(0,n-1,inorder,0,n-1,preorder,inMap);
    }
    public TreeNode helper(int is,int ie,int inorder[],int ps,int pe,int preorder[],HashMap<Integer,Integer> hm)
    {
        if(ps>pe || is>ie)
            return null;
        int inRoot = hm.get(preorder[ps]);
        int numsLeft = inRoot-is;
        TreeNode root = new TreeNode(inorder[inRoot]);
        root.left = helper(is,inRoot-1,inorder,ps+1,ps+numsLeft,preorder,hm);
        root.right = helper(inRoot+1,ie,inorder,ps+1+numsLeft,pe,preorder,hm);
        return root;
    }
}