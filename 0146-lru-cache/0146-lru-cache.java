class Node
{
    Node prev;
    Node next;
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

    HashMap<Integer,Node> hm = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity;

    public LRUCache(int capacity) 
    {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) 
    {
        if(hm.containsKey(key))
        {
            Node node = hm.get(key);
            delete(node);
            insert(node);
            return node.val;
        }
        else
        return -1;
    }
    
    public void put(int key, int value) 
    {
        if(hm.containsKey(key))
            delete(hm.get(key));
        if(hm.size()==capacity)
            delete(tail.prev);

        insert(new Node(key,value));
    }

    public void insert(Node node)
    {
        hm.put(node.key,node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void delete(Node node)
    {
        hm.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */