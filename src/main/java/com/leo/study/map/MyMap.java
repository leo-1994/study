package com.leo.study.map;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author chao.li@quvideo.com
 * @date 2019-05-28 16:04
 */
public class MyMap<K, V> extends AbstractMap<K, V> {

    private Node<K, V> head;

    private int size;


    private class Node<K, V> implements Entry<K, V> {

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        final K key;

        V value;

        Node<K, V> next;

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return this.value;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return this == obj || super.equals(obj);
        }
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<>();
        Node<K, V> curr = this.head;
        while (curr != null) {
            entrySet.add(curr);
            curr = curr.next;
        }
        return entrySet;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        Node<K, V> curr = this.head;
        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.next;
        }
        return defaultValue;
    }

    @Override
    public V put(K key, V value) {
        Node<K, V> curr = this.head;
        while (curr != null) {
            if (curr.key.equals(key)) {
                V result = curr.value;
                curr.value = value;
                return result;
            }
            curr = curr.next;
        }
        this.head = new Node<>(key, value, this.head);
        return null;
    }


    @Override
    public V putIfAbsent(K key, V value) {
        Node<K, V> curr = this.head;
        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.next;
        }
        this.head = new Node<>(key, value, this.head);
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) {
        Node<K, V> curr = this.head;
        Node<K, V> pre = null;
        while (curr != null) {
            if (curr.key.equals(key) && curr.value.equals(value)) {
                if (pre == null) {
                    this.head = head.next;
                } else {
                    pre.next = curr.next;
                }
                return true;
            }
            pre = curr;
            curr = curr.next;
        }
        return false;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return false;
    }

    @Override
    public V replace(K key, V value) {
        return null;
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return null;
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return null;
    }
}
