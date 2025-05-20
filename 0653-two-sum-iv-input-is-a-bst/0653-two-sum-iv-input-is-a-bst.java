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
 class BSTIterator
 {
    Stack<TreeNode> st = new Stack<>();
    boolean reverse = false;
    BSTIterator(TreeNode root,boolean isReverse)
    {
        reverse = isReverse;
        pushAll(root);
    }

    public void pushAll(TreeNode root)
    {
        while(root!=null)
        {
            st.push(root);
            if(reverse==false)
                root = root.left;
            else
                root = root.right;
        }
    }

    public int next()
    {
        TreeNode pop = st.pop();
        if(reverse==false)
            pushAll(pop.right);
        else
            pushAll(pop.left);

        return pop.val;
    }
 }
class Solution 
{
    public boolean findTarget(TreeNode root, int k) 
    {
         if(root==null)
            return false;
        BSTIterator l = new BSTIterator(root,false);
        BSTIterator r = new BSTIterator(root,true);

        int i = l.next();
        int j = r.next();

        while(i<j)
        {
            if(i+j==k)
                return true;
            if(i+j<k)
                i = l.next();
            else
                j = r.next();
        }

        return false;

    }
}