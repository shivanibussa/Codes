/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        if(root==null)
            return "n ";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();   
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node == null)
            {
                sb.append("n ");
                continue;
            }
            sb.append(node.val+" ");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        if(data=="")
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        String [] values = data.split(" ");
        if (values[0].equals("n")) 
            return null;  
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for(int i=1;i<values.length;i++)
        {
            TreeNode parent = q.poll();
            if(!values[i].equals("n"))
            {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                q.add(left);
                parent.left = left;
            }
            if(!values[++i].equals("n"))
            {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                q.add(right);
                parent.right = right;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));