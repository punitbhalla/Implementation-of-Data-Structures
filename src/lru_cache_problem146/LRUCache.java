package lru_cache_problem146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Entry {
        int key;
        int val;
        Entry next;
        Entry prev;

        public Entry(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (this.getClass() != o.getClass()) return false;
            return this.key == ((Entry) o).key && this.val == ((Entry) o).val;
        }

        @Override
        public int hashCode() {
            return this.key;
        }
    }


    int size;
    int capacity;
    Map<Integer, Entry> lruMap;
    Entry head;
    Entry tail;

    public LRUCache(int capacity) {
        this.lruMap = new HashMap<>();
        this.head = null;
        this.tail = head;
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        Entry item = lruMap.get(key);
        int value = 0;
        if (item == null || size <= 0) {
            return -1;
        } else {
            value = item.val;
            if (size > 1 && item != head) {
                removeNode(item);
                addNode(item);
            }
        }
        return value;
    }

    public void put(int key, int value) {
        Entry item = lruMap.get(key);
        if (item == null) {
            Entry entry = new Entry(key, value);
            if (size == capacity) {
                lruMap.remove(tail.key);
                removeNode(tail);
            }
            lruMap.put(key, entry);
            addNode(entry);
        } else {
            item.val = value;
            if (size > 1 && item != head) {
                removeNode(item);
                addNode(item);
            }
            return;
        }
    }

    private void addNode(Entry entry) {
        if (head == null) {
            head = entry;
            tail = head;
        } else {
            entry.next = head;
            entry.prev = null;
            head.prev = entry;
            head = entry;
        }
        size++;
    }

    private void removeNode(Entry entry) {
        if (size == 1) {
            head = null;
            tail = head;
        } else {
            Entry temp = entry;
            (temp.prev).next = temp.next;
            if (temp != tail) {
                (temp.next).prev = temp.prev;
            } else {
                tail = temp.prev;
            }
        }
        size--;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));        // returns -1 (not found)
        System.out.println(cache.get(3));        // returns 3
        System.out.println(cache.get(4));        // returns 4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */