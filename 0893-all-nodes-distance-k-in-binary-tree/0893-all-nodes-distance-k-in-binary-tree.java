/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution 
{
    public void parentsFeed(HashMap<TreeNode,TreeNode> parents, TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode pop = q.poll();
            if(pop.left!=null)
            {
                q.offer(pop.left);
                parents.put(pop.left,pop);
            }
            if(pop.right!=null)
            {
                q.offer(pop.right);
                parents.put(pop.right,pop);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) 
    {
        HashMap<TreeNode,TreeNode> parents = new HashMap<>();
        parentsFeed(parents,root);
        ArrayList<Integer> res =new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        int curr=0;

        q.offer(target);
        while(!q.isEmpty())
        {
            int s = q.size();
            if(curr==k)
                break;
            
            curr++;
            for(int i=0;i<s;i++)
            {
                TreeNode pop = q.poll();
                visited.put(pop,true);

                if(pop.left!=null && visited.get(pop.left)==null)
                {
                    q.offer(pop.left);
                    visited.put(pop.left,true);
                }
                if(pop.right!=null && visited.get(pop.right)==null)
                {
                    q.offer(pop.right);
                    visited.put(pop.right,true);
                }
                if(parents.get(pop)!=null  && visited.get(parents.get(pop))==null)
                {
                    q.offer(parents.get(pop));
                    visited.put(parents.get(pop),true);
                }
            }
        }
        while(!q.isEmpty())
        {
            res.add(q.poll().val);
        }
        return res;
    }
}