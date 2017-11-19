package Facebook.LRU_Cache_146;

import java.util.*;


//做到存取都在常量时间内，cache应该存在map中。
//为了能清除最少使用的元素，需要记录元素的访问次数。因为不需要记录确切的访问次数，可以使用双向链表来记录，每次访问，将最近的访问元素存放在链表头。

//corner case:
//需要考虑删除的元素是头部元素的情况，如capacity只有1
//需要考虑删除的元素是尾部元素的情况

class LRUCache {
    private class Node{
        int key, value;
        Node prev, next;
        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
        Node(){
            this(0, 0);
        }
    }

    private int capacity, count;
    private Map<Integer, Node> map;
    private Node head, tail;  //dummy head and dummy tail, head 和 tail都不存值

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        //get current node from the hashmap, if node is not exist, return -1;
        //if node is existed, return the value for this node, and move this node to the head
        Node n = map.get(key);
        if(null==n){
            return -1;
        }
        update(n);
        return n.value;
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if(null==n){
            //this node is not exist in the map
            n = new Node(key, value);
            map.put(key, n);
            addHead(n);
            ++count;
        }
        else{
            //update the value for this node, and move the node to head
            n.value = value;
            update(n);
        }
        if(count>capacity){
            //if count is larger than capacity,then we need to move the tail element.
            Node toDel = tail.prev;
            remove(toDel);
            map.remove(toDel.key);
            --count;
        }
    }

    private void update(Node node){
        remove(node);
        addHead(node);
    }
    private void addHead(Node node){
        //add current node to the head
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }

    private void remove(Node node){
        //remove current node
        Node before = node.prev, after = node.next;
        before.next = after;
        after.prev = before;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


