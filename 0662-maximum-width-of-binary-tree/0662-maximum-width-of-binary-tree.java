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
 class Pair
 {
    int num;
    TreeNode node;
    Pair(TreeNode node,int num)
    {
        this.node = node;
        this.num = num;
    }
 }
class Solution 
{
    public int widthOfBinaryTree(TreeNode root) 
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int maxAns = 0;
        while(!q.isEmpty())
        {
            int min = q.peek().num;
            int f=0,l=0,s=q.size();
            for(int i=0;i<s;i++)
            {
                Pair pop = q.poll();
                int ind = pop.num-min;
                TreeNode node = pop.node;
                if(i==0)
                    f = ind;
                if(i==s-1)
                    l = ind;

                if(node.left!=null)
                    q.add(new Pair(node.left,2*ind+1));
                if(node.right!=null)
                    q.add(new Pair(node.right,2*ind+2));
            }
            maxAns = Math.max(maxAns,l-f+1);
        }
        return maxAns;
    }
}