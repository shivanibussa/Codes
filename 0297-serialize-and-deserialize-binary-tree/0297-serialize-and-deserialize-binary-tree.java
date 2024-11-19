public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "n ";  // Return "n " for a null root
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("n ");  // Append "n " for null nodes
                continue;
            }
            sb.append(node.val + " ");  // Append the node's value
            q.add(node.left);  // Add left child to queue
            q.add(node.right);  // Add right child to queue
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] values = data.split(" ");  // Split the serialized string into values
        if (values[0].equals("n")) return null;  // If the root is null, return null

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));  // Create root node
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);  // Add root to queue

        int i = 1;  // Start processing children from index 1
        while (i < values.length) {
            TreeNode parent = q.poll();  // Get the next parent node

            // Process the left child
            if (!values[i].equals("n")) {  // If it's not a null node
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));  // Create left child
                parent.left = left;  // Assign to parent's left
                q.add(left);  // Add to queue for further processing
            }
            i++;  // Move to next value (left child processed)

            // Process the right child
            if (i < values.length && !values[i].equals("n")) {  // If it's not a null node
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));  // Create right child
                parent.right = right;  // Assign to parent's right
                q.add(right);  // Add to queue for further processing
            }
            i++;  // Move to next value (right child processed)
        }
        return root;  // Return the root node
    }
}
