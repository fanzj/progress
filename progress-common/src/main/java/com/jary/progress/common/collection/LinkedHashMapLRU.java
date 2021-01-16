package com.jary.progress.common.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author fanzhengjie
 * @create 2020/2/19 下午10:42
 * @description
 */
public class LinkedHashMapLRU<K, V> extends LinkedHashMap<K, V> implements Map<K, V> {

    public LinkedHashMapLRU(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    /**
     * 重写LinkedHashMap中的removeEldestEntry方法，当LRU中元素多余6个时，删除最不经常使用的元素
     *
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        if (size() > 6) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedHashMapLRU<Character, Integer> lru = new LinkedHashMapLRU<Character, Integer>(
                16, 0.75f, true);

        //gijklh
        String s = "abcdefghijkl";
        for (int i = 0; i < s.length(); i++) {
            lru.put(s.charAt(i), i);
        }
        System.out.println("LRU中key为h的Entry的值为： " + lru.get('h'));
        System.out.println("LRU的大小 ：" + lru.size());
        System.out.println("LRU ：" + lru);
    }
}
