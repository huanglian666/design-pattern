package algorithm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Title: <br/>
 * Description: <br/>
 * Copyright: 2024 <br/>
 * Company:<br/>
 * Project: design-pattern <br/>
 *
 * @Author huanglian <br/>
 * Create Time:7/15/24 08:23 <br/>
 */
public class MyHashMap<K, V> {
    private final int size;
    private final Entry<K, V>[] table;

    @SuppressWarnings("unchecked")
    public MyHashMap(int size) {
        if (size <= 0 || (size & (size - 1)) != 0) {
            throw new IllegalArgumentException("Size must be a positive power of 2");
        }
        this.size = size;
        this.table = (Entry<K, V>[]) new Entry[size];
    }

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        this.size = 16;
        this.table = (Entry<K, V>[]) new Entry[16];
    }

    private int hash(K key) {
        return key.hashCode() & (size - 1);
    }

    public V get(K key) {
        Entry<K, V> entry = table[hash(key)];
        if (entry == null) {
            return null;
        } else {
            while (entry.next != null) {
                if (entry.key == key) {
                    return entry.value;
                }
                entry = entry.next;
            }
            if (entry.key == key) {
                return entry.value;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> entry = table[index];

        if (entry == null) {
            table[index] = new Entry<>(key, value);
        }
        else {
            while (entry.next != null) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }

            if (entry.key == key) {
                entry.value = value;
                return;
            }
            entry.next = new Entry<>(key, value);
        }


    }

    @Setter
    @Getter
    @NoArgsConstructor
    private static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
