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
    public void parentsFeed(HashMap<TreeNode,TreeNode> tm,TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // HashMap<Tr,Integer>tm = new HashMap<>();
        while(!q.isEmpty())
        {
            TreeNode pop = q.poll();
            if(pop.left!=null)
            {
                q.add(pop.left);
                tm.put(pop.left,pop);
            }   
            if(pop.right!=null)
            {
                q.add(pop.right);
                tm.put(pop.right,pop);
            }
        }
    }
    public TreeNode getStart(int start,TreeNode root)
    {
        if(root.val==start)
            return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode pop = q.poll();
            if(pop.val==start)
                return pop;
            if(pop.left!=null)
            {
                q.add(pop.left);
            }
            if(pop.right!=null)
            {
                q.add(pop.right);
            }
        }
        return null;
    }
    public int amountOfTime(TreeNode root, int start) 
    {
        HashMap<TreeNode,TreeNode> parents = new HashMap<>();
        parentsFeed(parents,root);
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        TreeNode target = getStart(start,root);
        q.add(target);
        int steps=0;
        while(!q.isEmpty())
        {
            steps++;
            int s = q.size();
            for(int i=0;i<s;i++)
            {
                TreeNode pop = q.poll();
                visited.put(pop,true);
                if(pop.left!=null && visited.get(pop.left)==null)
                {
                    q.add(pop.left);
                    visited.put(pop.left,true);
                }
                if(pop.right!=null && visited.get(pop.right)==null)
                {
                    q.add(pop.right);
                    visited.put(pop.right,true);
                }
                if(parents.get(pop)!=null && visited.get(parents.get(pop))==null)
                {
                    q.add(parents.get(pop));
                    visited.put(parents.get(pop),true);
                }
            }
        }
        return steps-1;
    }
}