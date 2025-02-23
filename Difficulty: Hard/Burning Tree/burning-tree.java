//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            int target = Integer.parseInt(br.readLine());
            Node root = buildTree(s);

            Solution g = new Solution();
            System.out.println(g.minTime(root, target));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /*class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }*/
    public static void parentFeed(HashMap<Node,Node> parents,Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            Node node = q.poll();
            if(node.left!=null)
            {
                q.offer(node.left);
                parents.put(node.left,node);
            }
            if(node.right!=null)
            {
                q.offer(node.right);
                parents.put(node.right,node);
            }
        }
    }
    public static int minTime(Node root, int target) 
    {
        // code here
        HashMap<Node,Node> parents = new HashMap<>();
        parentFeed(parents,root);
        ArrayList<Integer> res = new ArrayList<>();
        int curr=0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node targetN = null;
        while(!q.isEmpty())
        {
            Node node = q.poll();
            if(node.data==target)
            {
                targetN = node;
                break;
            }
            if(node.left!=null)
            {
                q.offer(node.left);
            }
            if(node.right!=null)
            {
                q.offer(node.right);
            }
        }
        q.clear();
        HashMap<Node,Boolean> visited = new HashMap<>();
        q.offer(targetN);
        visited.put(targetN,true);
        while(!q.isEmpty())
        {
            int size=q.size();
            curr++;
            for(int i=0;i<size;i++)
            {
                Node pop = q.poll();
                // visited.put(pop,true);
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
                if(parents.get(pop)!=null && visited.get(parents.get(pop))==null)
                {
                    q.offer(parents.get(pop));
                    visited.put(parents.get(pop),true);
                }
            }
            
        }
        return curr-1;
    }
}