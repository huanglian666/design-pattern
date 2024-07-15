package algorithm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.StringJoiner;
import java.util.function.BiConsumer;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        StringJoiner joiner = new StringJoiner(",");
        this.forEach((k, v) -> joiner.add("\"" + k + "\":\"" + v + "\""));
        sb.append(joiner).append("}");
        return sb.toString();
    }

    public void forEach(BiConsumer<K, V> consumer) {
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                while (entry.next != null) {
                    consumer.accept(entry.key, entry.value);
                    entry = entry.next;
                }
                consumer.accept(entry.key, entry.value);
            }
        }
    }

    public K remove(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        if (entry == null) {
            return null;
        } else {

            if (entry.key == key) {
                table[index] = entry.next;
                return entry.key;
            }

            Entry<K, V> previous = entry;
            entry = entry.next;

            while (entry != null && entry.next != null) {
                if (entry.key == key) {
                    previous.next = entry.next;
                    entry.next = null;
                    return entry.key;
                }

                previous = entry;
                entry = entry.next;
            }

            if (entry != null && entry.key == key) {
                previous.next = null;
                return entry.key;
            }



        }
        return null;
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
