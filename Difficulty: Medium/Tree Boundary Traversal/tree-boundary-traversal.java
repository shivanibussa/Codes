//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundaryTraversal(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution 
{
    ArrayList<Integer> boundaryTraversal(Node root) 
    {
        ArrayList<Integer> al = new ArrayList<>();
        if(root ==null)
	    return al;
	    if (!isLeaf(root)) 
	        al.add(root.data);
        addLeftBoundary(root,al);
        addLeaves(root,al);
        addRightBoundary(root,al);
        return al;
    }
    public static boolean isLeaf(Node root)
    {
        if(root.left==null && root.right==null)
            return true;
        return false;
    }
    
    public static void addLeftBoundary(Node node, ArrayList<Integer> al)
    {
        Node curr = node.left;
        while(curr!=null)
        {
            if(!isLeaf(curr))
            {
                al.add(curr.data);
            }
            if(curr.left!=null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }
    
    public static void addRightBoundary(Node node, ArrayList<Integer> al)
    {
        Node curr = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr!=null)
        {
            if(!isLeaf(curr))
            {
                temp.add(curr.data);
            }
            if(curr.right!=null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        Collections.reverse(temp);
        al.addAll(temp);
    }
    
    public static void addLeaves(Node node, ArrayList<Integer> al)
    {
        if(isLeaf(node))
            al.add(node.data);
        if(node.left!=null)
            addLeaves(node.left,al);
        if(node.right!=null)
            addLeaves(node.right,al);
    }
    
}
