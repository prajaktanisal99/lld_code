import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private final int capacity;
    private Node<K, V> head;
    private Node<K, V> tail;
    private Map<K, Node<K, V>> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        cache = new HashMap<>(capacity);
        head = new Node(null, null);
        tail = new Node(null, null);

        head.next = tail;
        tail.prev = head;
    }

    public synchronized V get(K key) {

        Node<K, V> node = cache.get(key);
        // if not present in cache return -1
        if (node == null) {
            return null;
        }
        // if present in cache -> moveToHead() and return value
        moveToHead(node);
        return node.value;
    }

    public synchronized void put(K key, V value) {
        Node<K, V> node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            node = new Node<>(key, value);
            cache.put(key, node);
            addToHead(node);
            // check if addition of new node exceeds capacity
            if (capacity < cache.size()) {
                Node<K, V> leadRecentlyUsedNode = removeFromTail();
                cache.remove(leadRecentlyUsedNode.key);
                System.out.println("Removed node -> " + leadRecentlyUsedNode.key);
            }
        }
    }

    private void moveToHead(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private Node<K, V> removeFromTail() {
        Node<K, V> node = tail.prev;
        removeNode(node);
        return node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}