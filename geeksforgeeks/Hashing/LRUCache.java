/*
problem: https://leetcode.com/problems/lru-cache/description/
author: parag kumar goyal
TC: 
get() O(1) average
put() O(1) average
Evict least recently used key O(1)

SC:
O(capacity)

This is not thread-safe; it is correct for the usual single-threaded LRU-cache interview/LeetCode problem.
*/

import java.util.LinkedHashMap;
import java.util.Map;

class LinkedLRUCache<K, V> extends LinkedHashMap<K, V> {
    int capacity;

    LinkedLRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        size() > capacity;
    } 
}


class LRUCache {
    LinkedLRUCache<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LinkedLRUCache(capacity);
    }

    public int get(int key) {
        Integer ans = cache.get(key);
        return ans == null ? -1 : ans;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}