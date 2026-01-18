package main.systemdesign;

import java.util.HashMap;
import java.util.Map;

class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
public class LRUCache {
    Map<Integer, Node> cache;
    int capacity;
    Node head;
    Node tail;

    LRUCache(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node = cache.get(key);
        removeNode(node);
        addToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        if(!cache.containsKey(key)){
            if(cache.size() == capacity){
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            addToHead(node);
        }else{
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        }
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
    }
}
