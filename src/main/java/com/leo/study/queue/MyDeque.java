package com.leo.study.queue;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author chao.li@quvideo.com
 * @date 2019-05-24 10:17
 */
public class MyDeque<E> implements Deque<E> {

    public MyDeque(int limit) {
        this.limit = limit;
        this.size = 0;
    }

    private int size;

    private int limit;

    private Node first;

    private Node last;

    private class Node {
        E data;
        Node pre;
        Node next;

        Node(E e) {
            this.data = e;
        }
    }

    @Override
    public void addFirst(E e) {
        if (!offerFirst(e)) {
            throw new RuntimeException("队列已满");
        }
    }

    @Override
    public void addLast(E e) {
        if (!offerLast(e)) {
            throw new RuntimeException("队列已满");
        }
    }

    @Override
    public boolean offerFirst(E e) {
        if (size >= limit) {
            return false;
        }
        if (first == null) {
            this.first = new Node(e);
            this.last = this.first;
        } else {
            Node node = new Node(e);
            node.next = first;
            this.first.pre = node;
            this.first = node;
        }
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (size >= limit) {
            return false;
        }
        if (last == null) {
            this.last = new Node(e);
            this.first = this.last;
        } else {
            Node node = new Node(e);
            node.pre = this.last;
            this.last.next = node;
            this.last = node;
        }
        size++;
        return true;
    }

    @Override
    public E removeFirst() {
        E result = pollFirst();
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public E removeLast() {
        E result = pollLast();
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    /**
     * 删除链表中的一个节点
     *
     * @param node
     */
    private void removeNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        if (pre != null) {
            pre.next = next;
        }
        if (next != null) {
            next.pre = pre;
        }
        size--;
    }

    @Override
    public E pollFirst() {
        if (size <= 0) {
            return null;
        }
        E result = first.data;
        removeNode(first);
        return result;
    }

    @Override
    public E pollLast() {
        if (size <= 0) {
            return null;
        }
        E result = last.data;
        removeNode(last);
        return result;
    }

    @Override
    public E getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    @Override
    public E getLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        return last.data;
    }

    @Override
    public E peekFirst() {
        if (first == null) {
            return null;
        }
        return first.data;
    }

    @Override
    public E peekLast() {
        if (last == null) {
            return null;
        }
        return last.data;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        Node c = first;
        while (c != null) {
            if (o.equals(c.data)) {
                removeNode(c);
                return true;
            }
            c = c.next;
        }
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        Node c = last;
        while (c != null) {
            if (o.equals(c.data)) {
                removeNode(c);
                return true;
            }
            c = c.pre;
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        return offer(e);
    }

    @Override
    public boolean offer(E e) {
        return offerFirst(e);
    }

    @Override
    public E remove() {
        return poll();
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public E peek() {
        return peekFirst();
    }

    @Override
    public void push(E e) {
        offerFirst(e);
    }

    @Override
    public E pop() {
        return pollFirst();
    }

    @Override
    public boolean remove(Object o) {
        return removeFirstOccurrence(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Ite();
    }

    private class Ite implements Iterator<E> {

        private int index = 0;

        private Node curr = first;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            if (hasNext()) {
                E result = curr.data;
                index++;
                curr = curr.next;
                return result;
            }
            return null;
        }

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new DescIte();
    }

    private class DescIte implements Iterator<E> {

        private int index = 0;

        private Node curr = last;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            if (hasNext()) {
                E result = curr.data;
                index++;
                curr = curr.pre;
                return result;
            }
            return null;
        }

    }
}
