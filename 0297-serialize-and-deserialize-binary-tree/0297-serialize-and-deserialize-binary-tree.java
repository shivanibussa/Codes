public class Codec 
{
    public String serialize(TreeNode root) 
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty())
        {
            TreeNode pop = q.poll();
            if(pop==null)
            {
                sb.append("n ");
                continue;
            }
            sb.append(pop.val);
            sb.append(" ");
            q.add(pop.left);
            q.add(pop.right);
        }
        System.out.println(sb);
        return sb.toString();
    }
    public TreeNode deserialize(String data) 
    {
        Queue<TreeNode> q = new LinkedList<>();
        if(data == null || data.isEmpty() || data.equals("n "))
            return null;
        
        String values[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        q.add(root);
        for(int i=1;i<values.length;i++)
        {
            TreeNode parent = q.poll();
            if(!values[i].equals("n"))
            {
                TreeNode left = new TreeNode(Integer.valueOf(values[i]));
                parent.left = left;
                q.add(left);
            }
            if(!values[++i].equals("n"))
            {
                TreeNode right = new TreeNode(Integer.valueOf(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
