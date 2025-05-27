class Node
{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key,int val)
    {
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
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
        this.hm = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public void insertNode(Node node)
    {
        Node prev = this.tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.tail;
        this.tail.prev = node;
    }

    public void deleteNode(Node node)
    {
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }
    public int get(int key) 
    {
        if(hm.containsKey(key))
        {
            Node node = hm.get(key);
            deleteNode(node);
            insertNode(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) 
    {
        if(hm.containsKey(key))
        {
            deleteNode(hm.get(key));
        }
        Node newNode = new Node(key,value);
        hm.put(key,newNode);
        insertNode(newNode);

        if(hm.size()>capacity)
        {
            Node lru = this.head.next;
            hm.remove(lru.key);
            deleteNode(lru);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */