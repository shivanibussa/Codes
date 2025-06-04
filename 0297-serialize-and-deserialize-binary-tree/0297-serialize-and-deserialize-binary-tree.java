/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec 
{
    public String serialize(TreeNode root) 
    {
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        if(root==null)
            return "";
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode pop = q.poll();
            if(pop==null)
            {
                sb.append("n ");
            }
            else
            {
                sb.append(pop.val).append(" ");
                q.offer(pop.left);
                q.offer(pop.right);
            }
        }
        return sb.toString();
    }

   public TreeNode deserialize(String s) 
    {
        if(s=="")
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        String values[] = s.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        q.add(root);
        for(int i=1;i<values.length;i++)
        {
            TreeNode parent = q.poll();
            if(!values[i].equals("n"))
            {
                TreeNode left = new TreeNode(Integer.valueOf(values[i]));
                parent.left = left;
                q.offer(left);
            }
            if(!values[++i].equals("n"))
            {
                TreeNode right = new TreeNode(Integer.valueOf(values[i]));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));