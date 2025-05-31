class Node
{
    Node next;
    Node prev;
    int key;
    int val;

    Node(int key,int val)
    {
        this.key = key;
        this.val = val;
    }

    
}
class LRUCache 
{
    private int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer,Node> hm;
    public LRUCache(int capacity) 
    {
        this.capacity = capacity;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        hm = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) 
    {
        if(hm.containsKey(key))
        {
            Node node = hm.get(key);
            removeNode(node);
            insertNode(node);
            return node.val;
        }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value) 
    {
        if(hm.containsKey(key))
            removeNode(hm.get(key));
        if(hm.size()==capacity)
            removeNode(tail.prev);

        insertNode(new Node(key,value));
    }

    private void insertNode(Node node)
    {
        hm.put(node.key,node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(Node node)
    {
        hm.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */